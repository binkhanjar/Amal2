package com.jks.amal.CancerOthers;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jks.amal.R;

import java.util.ArrayList;

public class Detection extends AppCompatActivity {


    RvAdapterOthers mAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemsOthers> mItems;
    RecyclerView.LayoutManager mlayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detection);


        recyclerView = findViewById(R.id.recyclerView_others);


            mItems = new ArrayList<>();
            mItems.add(new ItemsOthers("فحص الثّدي السّريري","هو إجراء بسيط تقوم الطّبيبة أو الأخصائيّة بفحص الثّديين والمناطق المحيطة بهما للكشف عن أي كتل، أو تغيير غير طبيعي قد يدلّ على الإصابة بسرطان الثّدي.\n" +
                    "\n",R.drawable.bed));
            mItems.add(new ItemsOthers("تصوير الثّدي الماموجرام","الماموجرام هو نوع من أنواع صور الأشعّة السينية المستخدمة للكشف عن وجود أورام أو كتل أو تغييرات في الثّدي. يتم تصوير كلّ ثدي بوجهتين مختلفتين للحصول على صور كاملة. يجب عليك الاحتفاظ بصور الأشعّة السابقة دائما لمقارنتها بالصور الجديدة." +
                "\n", R.drawable.x_ray));
            mItems.add(new ItemsOthers("تنظير القولون","تنظير القولون هو إجراء طبي يقوم خلاله الطبيب بإدخال أنبوب رفيع وطويل وفي نهايته ضوء وكاميرا للنظر داخل القولون والمستقيم." +
                "\n", R.drawable.colon_cancer));
            mItems.add(new ItemsOthers("فحص الدم الخفي في البراز","هو فحص يكشف عن وجود دم في البراز، والذي قد يكون أحد أعراض الإصابة بسرطان القولون. وهو فحص بسيط، وسريع، وغير مؤلم." +
                "\n", R.drawable.medical_test));
            mItems.add(new ItemsOthers("فحوصات البروستات","تساعد فحوصات البروستات الأطباء على الكشف المبكّر عن سرطان البروستات، مما يزيد خيارات العلاج ويزيد من فاعليّتها." +
                "\n", R.drawable.prostate_cancer));
            mItems.add(new ItemsOthers("مسحة عنق الرّحم","هو فحص يكشف عن سرطان عنق الرّحم، حيث يبحث عن أيّ تغيّر في خلايا عنق الرّحم، وإذا هناك أيّ خلايا سرطانيّة، أو أيّ خلايا غير طبيعية يمكن أن تؤدي إلى سرطان الرّحم." +
                "\n", R.drawable.cervical_cancer));

        recyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new RvAdapterOthers(mItems, getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(mAdapter);

        // طلب اظهار سهم العودة للصفحة الرئيسية مع وضع parent in manifest
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
