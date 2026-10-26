
package org.mishkat.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int dp(int value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density);
    }

    private TextView makeText(String text, int size) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(Color.rgb(35, 55, 45));
        view.setGravity(Gravity.CENTER);
        view.setPadding(dp(12), dp(14), dp(12), dp(14));
        return view;
    }

    private void addSection(LinearLayout parent,
                            String title, String body) {
        TextView heading = makeText(title, 22);
        heading.setTypeface(null, Typeface.BOLD);
        parent.addView(heading);

        TextView content = makeText(body, 17);
        parent.addView(content);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(20, 65, 48));
        getWindow().setNavigationBarColor(Color.rgb(20, 65, 48));

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.rgb(247, 246, 239));

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(16), dp(20), dp(16), dp(24));

        TextView title = makeText("المشكاة", 32);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.rgb(20, 90, 62));
        page.addView(title);

        page.addView(makeText(
            "نورٌ للقلوب، وعلمٌ نافع بإذن الله", 18));

        addSection(page, "القرآن الكريم",
            "اقرأ القرآن بتدبر، واجعل لك وردًا يوميًا.");

        addSection(page, "الأذكار والأدعية",
            "اللهم أعنّا على ذكرك وشكرك وحسن عبادتك.");

        addSection(page, "الحديث النبوي",
            "سيُضاف محتوى موثّق مع مصادره وتخريجه بعد مراجعته.");

        addSection(page, "دعاء لشهداء اليمن",
            "اللهم اغفر لموتى المسلمين، وارحم شهداء شبوة "
            + "وجميع شهداء اليمن، وأسكنهم فسيح جناتك، "
            + "واجبر قلوب أهلهم، واحفظ اليمن وأهله، "
            + "وانشر الأمن والسلام.");

        page.addView(makeText(
            "مشروع خيري مجاني — نسأل الله القبول", 14));

        scroll.addView(page);
        setContentView(scroll);
    }
}
