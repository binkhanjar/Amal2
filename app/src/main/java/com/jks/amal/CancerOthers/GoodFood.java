package com.jks.amal.CancerOthers;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jks.amal.R;

import java.util.ArrayList;

public class GoodFood extends AppCompatActivity {

    RvAdapterOthers mAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemsOthers> mItems;
    RecyclerView.LayoutManager mlayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_food);


        recyclerView = findViewById(R.id.recyclerView_others);


        mItems = new ArrayList<>();
        mItems.add(new ItemsOthers("الطماطم","وائد الطماطم كثيرة فهي تحتوي على مادة \"الليكوبين\" التي تساهم في محاربة أمراض القلب والأوعية الدموية. لكنها أيضا تحتوي على مضادات للأكسدة وتساهم في محاربة الخلايا السرطانية. وحسب جامعة هارفارد الأمريكية في دراسة من عام 1999 فالطماطم تقلل من خطر الإصابة بسرطان البروستاتا بنحو 30 بالمائة شرط تناول أطباق غنيّة بالطماطم يوميّا.",R.drawable.tomato));
        mItems.add(new ItemsOthers("شوفان","ينصح بتناول المواد الغنيّة بالألياف خاصة لتقليل خطر الإصابة بسرطان الثدي، مقابل الابتعاد عن السكريات. وحسب دراسة أمريكية حديثة، فإنّ تناول 10 غرامات من الشوفان أو غيره يوميا، يكفي لكبح خطر الإصابة بسرطان الثدي أو البلعوم بواقع سبعة بالمائة.", R.drawable.grain));
        mItems.add(new ItemsOthers("الفراولة","هذه الفواكه تكبح نموّ الأورام، وذلك بفضل الكميات الهائلة من الغليكوسيد والمواد المضادة للأكسدة التي تحتوي عليها. وأظهرت العديد من الدراسات أن 15 حبّة منها يوميا، قادرة على المساعدة في محاربة سرطان الثدي والمريء.",R.drawable.strawberry));
        mItems.add(new ItemsOthers("بروكلي"," الخضار خضراء اللّون بما في ذلك السلاطة والكرنب الأخضر والبروكولي وغيرها. خاصة البروكولي يقول الأطباء إنه يقضي على المواد المسببة للسرطان والتي تحتوي عليها اللحوم الحمراء.",R.drawable.broccoli));
        mItems.add(new ItemsOthers("الحوامض"," الحوامض بدورها تساعد على وقف نمو الأورام. ويُنصح بتناول عصير الحوامض يوميا، على أن تكون عصائر طبيعية وغير جاهزة. كما أن قشرة الحوامض مفيدة جدا لتقليل السموم في الجسم، لكن يجب الانتباه أن تكون هذه القشرة طبيعية وخالية من المواد السّامة والمبيدات التي قد تستخدم في زراعة الفاكهة.", R.drawable.lemon));
        mItems.add(new ItemsOthers("الدواجن"," الدواجن عوض الأبقار\n" +
                "بات معروفا أن اللحوم الحمراء من محفّزات نمو الأورام السرطانية في الجسم. ولهذا ينصح بتناول الدجاج عوضا عن الأبقار أو الأغنام، لكونها لا يحتوي على ذات القدر من البروتينات السامة.", R.drawable.chicken_leg));
        mItems.add(new ItemsOthers("الجوز","الجوز غني بشكل خاص من فيتامين E يسمى غاما توكوفيرول المعروف عنه أنه يوقف مسار الإشارات لأنزيم البروتين المسمى Akt. هذا الأنزيم مسؤول عن تنظيم التمثيل الغذائي وبقاء الخلية، كما أنه يقوم بمهاجمة وتدمير الخلايا السرطانية، ويمنع على سبيل المثال وقف مستقبلات هرمون الأستروجين وبالتالي يمنع سرطان الثدي.", R.drawable.nut));
        mItems.add(new ItemsOthers("الاسماك"," تعتبر الأسماك صحية لاحتوائها على أحماض أوميغا 3 الدهنية وفيتامين د. السلمون والرنجة توصف بقنابل فيتامين. وفحصت دراسة أمريكية حوالي 48 ألف رجل على مدى 12 عشر عامًا. أولئك الذين تناولوا الأسماك - ويفضل السلمون - أكثر من ثلاث مرات أسبوعيا، كانوا أقل عرضة بنسبة 40 في المائة للإصابة بسرطان البروستاتا المتقدم. ولدى النساء، يقال إن تناول الأسماك يقلل من خطر الإصابة بسرطان الثدي إلى النصف تقريبًا.", R.drawable.fish));
        mItems.add(new ItemsOthers("الثوم"," يحتوي الثوم على مركبات الكبريت التي يمكن أن تساعد في الحد من مخاطر تطوّر أنواع مختلفة من أمراض السرطان. والثوم أيضا مصدر جيد لفيتامين بي 6 والمنغنيز.", R.drawable.garlic));
        mItems.add(new ItemsOthers("الشاي الأخضر"," يعد الشاي الأخضر غنيا بمادة البوليفينول، التي يعتقد أنها تساعد في منع نمو الخلايا السرطانية. ويعتقد أيضا أن الأوراق المجففة من هذا النبات تعزز نظام المناعة وتزيل السموم وتحسن الصحة العامة.", R.drawable.green_tea));

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
