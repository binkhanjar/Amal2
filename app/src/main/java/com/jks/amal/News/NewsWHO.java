package com.jks.amal.News;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.jks.amal.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class NewsWHO extends AppCompatActivity {

    ListView lv;
    ArrayList<List_item> ListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_who);
        lv = findViewById(R.id.Lv);

        ListItem = new ArrayList<>();

        Toast.makeText(getApplicationContext(), "انتظر قليلا", Toast.LENGTH_SHORT).show();

        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Uri uri = Uri.parse(ListItem.get(i).link);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        new ProcessInBackground().execute();

        // طلب اظهار سهم العودة للصفحة الرئيسية مع وضع parent in manifest
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }

    }

    @SuppressLint("StaticFieldLeak")
    public class ProcessInBackground extends AsyncTask<Integer, Void, Exception> {

        Exception exception = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Exception doInBackground(Integer... integers) {

            try {
                URL xmlurl = new URL("http://www.emro.who.int/index.php?option=com_mediarss&feed_id=5&format=raw");//العربية

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(getInputStream(xmlurl), "UTF_8");

                boolean GetItem = false;

                ArrayList<String> title = new ArrayList<>();
                ArrayList<String> link = new ArrayList<>();
                ArrayList<String> description = new ArrayList<>();
                ArrayList<String> pubDate = new ArrayList<>();

                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {

                        if (xpp.getName().equalsIgnoreCase("item")) {
                            GetItem = true;
                        } else if (xpp.getName().equalsIgnoreCase("title")) {
                            if (GetItem) {
                                title.add(xpp.nextText());
                            }
                        }
                        else if (xpp.getName().equalsIgnoreCase("link")) {
                            if (GetItem) {
                                link.add(xpp.nextText());
                            }
                        }

                        else if (xpp.getName().equalsIgnoreCase("description")) {
                            if (GetItem) {
                                description.add(xpp.nextText());
                            }
                        }
                        else if (xpp.getName().equalsIgnoreCase("pubDate")) {
                            if (GetItem) {
                                pubDate.add(xpp.nextText());
                            }
                        }

                    } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                        GetItem = false;
                    }

                    eventType = xpp.next();
                }

                for (int i = 0; i < title.size(); i++) {
                    List_item ls = new List_item();
                    ls.setTitle(title.get(i));
                    ls.setDescription(description.get(i));
                    ls.setLink(link.get(i));
                    ls.setPubDate(pubDate.get(i));
                    ListItem.add(ls);
                }


            } catch (XmlPullParserException | IOException e) {
                exception = e;
            }
            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);

            listAdapter list_Adapter = new listAdapter(ListItem);
            lv.setAdapter(list_Adapter);

        }
    }

    class listAdapter extends BaseAdapter {
        ArrayList<List_item> listItem;

        listAdapter(ArrayList<List_item> list) {
            this.listItem = list;
        }

        @Override
        public int getCount() {
            return listItem.size();
        }

        @Override
        public Object getItem(int i) {
            return listItem.get(i).title;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();

            @SuppressLint({"ViewHolder", "InflateParams"})
            View view1 = layoutInflater.inflate(R.layout.row_items, null);
            try {
                TextView title = view1.findViewById(R.id.tv_article_title);
                TextView Text_description = view1.findViewById(R.id.tv_description);
                TextView Text_pubdate = view1.findViewById(R.id.tv_date);

                title.setText(listItem.get(i).title);
                Text_pubdate.setText(listItem.get(i).pubDate);

                String Des = (listItem.get(i).description);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Text_description.setText(Html.fromHtml(Des, Html.FROM_HTML_MODE_COMPACT));
                }

            } catch (Exception ignored) {
            }
            return view1;

        }
    }

}
