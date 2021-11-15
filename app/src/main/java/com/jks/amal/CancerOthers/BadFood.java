package com.jks.amal.CancerOthers;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jks.amal.R;

import java.util.ArrayList;

public class BadFood extends AppCompatActivity {

    RvAdapterOthers mAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemsOthers> mItems;
    RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_food);
        recyclerView = findViewById(R.id.recyclerView_others);


        mItems = new ArrayList<>();
        mItems.add(new ItemsOthers("المشروبات الكحولية","زيد الإستهلاك المنتظم للمشروبات الكحولية أو الإفراط في تناولها من خطر الإصابة بالعديد من أنواع السرطان، مثل: سرطان الفم، سرطان الكبد وسرطان المعدة وغيرها.\n"
                , R.drawable.no_alcohol));
        mItems.add(new ItemsOthers("اللحوم المصنعة والحمراء","نشرت دراسة عام 2008، في مجلة التغذية والسرطان، تؤكد أن تناول اللحوم المصنعة «كاللانشون والسوسيس والبرجر»، قد يكون متورطا في مسببات سرطان القولون والمستقيم، جنبا إلى جنب مع اللحوم الحمراء، لذلك يجب تجنب الإفراط في تناول اللحوم الحمراء، وإذا كنت ترغب في تجنب الآثار الضارة من اللحوم المصنعة، استبدلها باللحوم الخالية من الدهون، لأنه يدخل في صناعتها مواد كيماية كـ «نترات الصوديوم عند تجميدها، مما يجعلها ضارة بصحتك، بالإضافة إلى ذلك، تحتوي اللحوم المصنعة على كمية كبيرة من الملح، وهو أمر سيء أيضًا».\n"
                , R.drawable.meat));
        mItems.add(new ItemsOthers("الأطعمة النية"," إن تناول بعض الأطعمة النيئة كأسماك المياه العذبة، قد تسبب الضرر للجسم. إذ قد تحتوي هذه الأطعمة قبل طبخها على بعض الطفيليات، مثل \n" +
                "(Opisthorchis viverrini) وهو طفيلي ينتقل عن طريق الغذاء، كما أنه أحد الأسباب الرئيسية لسرطان القناة الصفراوية."
                , R.drawable.food_serving));
        mItems.add(new ItemsOthers("الزيوت المهدرجة"," خلاف زيت الزيتون أو زيت الصويا أو زيت الكانولا، لا يتم استخلاص الزيوت المهدرجة بطريقة طبيعية، وبالتالي فهي ليست جيدة لصحة الإنسان، بمجرد استخراجه كيميائياً من الخضروات، يعالج الزيت المهدرج مرة أخرى كيميائيا لتغيير رائحته وطعمه، وكذلك لتمديد فترة صلاحيته، هذا النوع من النفط يستخدم عادة للحفاظ على الأطعمة المصنعة، وتؤثر على بنية ومرونة أغشية الخلايا، وهذا بدوره يزيد من خطر الإصابة بالسرطان، خاصة سرطان الجلد، بالإضافة إلى ذلك، فإن الدهون غير المشبعة في الزيوت المهدرجة تعزز سرطان الثدي وسرطان البروستاتا وسرطان القولون والمستقيم.\n" +
                "وأفضل شيء هو استخدام الزيوت الطبيعية للطهي، وليس الزيوت المهدرجة، ومن بين الأفضل: زيت الزيتون البكر وزيت جوز الهند البكر وزيت النخيل."
                , R.drawable.oil));
        mItems.add(new ItemsOthers("الأغذبة المعدلة وراثيا"," بما في ذلك البطاطا والذرة والحبوب وفول الصويا جميع هذه «المنتجات الغذائية» يتم زرعها بقوة باستخدام مواد كيميائية ضارة، وعندما تستهلك يمكن أن يؤدي إلى فشل نظام المناعة وتلف الدماغ والكبد، فالمواد الكيميائية المستخدمة في زراعة هذه الأطعمة تسبب نمو الورم السريع، لذلك يجب أن تقرأ عند شراء هذه الأغذية جملة «خالية من الكائنات المعدلة وراثيًا».\n"
                , R.drawable.food_serving));
        mItems.add(new ItemsOthers("الاطعمة المحلاة بالسكر","وفقا لدراسة عام 2006 ،نشرتها مجلة الجمعية الأمريكية للتغذية، فإن تناول كميات كبيرة من السكر المكرر والأطعمة المحلاة بالسكر يزيد من خطر الإصابة بسرطان البنكرياس، لذلك بدلا من استخدام السكر المكرر أو المحليات الاصطناعية، يمكنك تجربة معززات الطاقة الطبيعية مثل العسل، أو دبس السكر الأسود."
                , R.drawable.sugar_cubes));
        mItems.add(new ItemsOthers("الأطعمة المدخنة والمخللة"," تحتوي معظم الأطعمة المخللة على نترات تتحول إلى «N-nitroso»، ما يزيد من خطر الإصابة بالأورام، وعلاوة على ذلك فإنها تحتوي بانتظام على مواد حافظة لتمديد فترة الصلاحية، والتي تتراكم في جسمك مع مرور الوقت، هذا يمكن أن يسبب ضررا على المستوى الخلوي ويؤدي إلى السرطان وغيرها من الأمراض التي يصعب علاجها."
                , R.drawable.pickles));


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