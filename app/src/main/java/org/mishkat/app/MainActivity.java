
package org.mishkat.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout page;
    private final int green = Color.rgb(20, 85, 63);
    private final int cream = Color.rgb(248, 247, 238);

    private int dp(int n) {
        return (int) (n * getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(green);
        getWindow().setNavigationBarColor(green);
        showHome();
    }

    private TextView text(String value, int size, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(green);
        t.setGravity(Gravity.CENTER);
        t.setTextDirection(View.TEXT_DIRECTION_RTL);
        t.setPadding(dp(12), dp(12), dp(12), dp(12));
        if (bold) t.setTypeface(null, Typeface.BOLD);
        return t;
    }

    private void setup(String title) {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(cream);

        page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER_HORIZONTAL);
        page.setPadding(dp(18), dp(20), dp(18), dp(28));
        page.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        scroll.addView(page);
        setContentView(scroll);

        page.addView(text("المشكاة", 34, true));
        page.addView(text(title, 22, true));
    }

    private void addText(String value, int size, boolean bold) {
        page.addView(text(value, size, bold));
    }

    private void addButton(String label, final Runnable action) {
        Button b = new Button(this);
        b.setText(label);
        b.setTextSize(17);
        b.setTextColor(Color.WHITE);
        b.setAllCaps(false);
        b.setGravity(Gravity.CENTER);
        b.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(green)
        );

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, dp(58)
        );
        lp.setMargins(0, dp(7), 0, dp(7));
        page.addView(b, lp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.run();
            }
        });
    }

    private void showHome() {
        setup("نور للقلوب، وعلم نافع بإذن الله");

        addText("أهلًا بك في المشكاة", 22, true);
        addText("رفيقك للقراءة والذكر والدعاء", 17, false);

        addButton("📖 القرآن الكريم", new Runnable() {
            public void run() { showQuran(); }
        });

        addButton("🤲 الأذكار والأدعية", new Runnable() {
            public void run() { showAzkar(); }
        });

        addButton("📚 الحديث النبوي", new Runnable() {
            public void run() { showHadith(); }
        });

        addButton("🇾🇪 دعاء لشهداء اليمن", new Runnable() {
            public void run() { showYemen(); }
        });

        addText("مشروع خيري مجاني — نسأل الله القبول", 15, false);
    }

    private void showQuran() {
        setup("القرآن الكريم");
        addText("بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ", 22, true);
        addText("سورة الفاتحة", 20, true);
        addText("الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ", 23, false);
        addText("الرَّحْمَٰنِ الرَّحِيمِ", 23, false);
        addText("مَالِكِ يَوْمِ الدِّينِ", 23, false);
        addText("إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ", 23, false);
        addText("اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ", 23, false);
        addText("صِرَاطَ الَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّالِّينَ", 21, false);
        addText("هذه بداية تجريبية؛ سنضيف المصحف كاملًا لاحقًا.", 15, false);
        addButton("العودة للرئيسية", new Runnable() {
            public void run() { showHome(); }
        });
    }

    private void showAzkar() {
        setup("الأذكار والأدعية");
        addText("دعاء الإعانة على العبادة", 20, true);
        addText("اللهم أعني على ذكرك وشكرك وحسن عبادتك.", 22, false);
        addText("دعاء الاستغفار", 20, true);
        addText("أستغفر الله وأتوب إليه.", 22, false);
        addText("اذكر الله بقلب حاضر، واختر وقتًا يوميًا للذكر.", 17, false);
        addButton("العودة للرئيسية", new Runnable() {
            public void run() { showHome(); }
        });
    }

    private void showHadith() {
        setup("الحديث النبوي");
        addText("السنة النبوية نور وهداية", 22, true);
        addText("سيُضاف هنا محتوى من الأحاديث النبوية بعد مراجعة النصوص ومصادرها والتخريج؛ حرصًا على صحة النسبة إلى النبي ﷺ.", 19, false);
        addButton("العودة للرئيسية", new Runnable() {
            public void run() { showHome(); }
        });
    }

    private void showYemen() {
        setup("دعاء لشهداء اليمن");
        addText("اللهم اغفر لموتى المسلمين، وارحم شهداء شبوة وجميع شهداء اليمن، وأسكنهم فسيح جناتك، واجبر قلوب أهلهم، واحفظ اليمن وأهله، وانشر الأمن والسلام.", 22, false);
        addText("اللهم آمين.", 24, true);
        addButton("العودة للرئيسية", new Runnable() {
            public void run() { showHome(); }
        });
    }
}
