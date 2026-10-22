package ir.appyab;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends Activity {
    private EditText query;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 28, 24, 24);
        root.setLayoutDirection(ViewGroup.LAYOUT_DIRECTION_RTL);
        root.setBackgroundColor(Color.rgb(247,249,252));

        TextView title = new TextView(this);
        title.setText("اپ‌یاب");
        title.setTextSize(30);
        title.setTextColor(Color.rgb(26,82,160));
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(this);
        subtitle.setText("برنامهٔ مناسب خودت را در کافه‌بازار پیدا کن");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subp = new LinearLayout.LayoutParams(-1,-2);
        subp.setMargins(0, 10, 0, 22);
        root.addView(subtitle, subp);

        query = new EditText(this);
        query.setSingleLine(true);
        query.setTextSize(16);
        query.setHint("مثلاً: آموزش زبان، حسابداری، ویرایش عکس");
        root.addView(query, new LinearLayout.LayoutParams(-1, -2));

        CheckBox free = new CheckBox(this); free.setText("فقط برنامه‌های رایگان"); root.addView(free);
        CheckBox rated = new CheckBox(this); rated.setText("امتیاز بالا"); root.addView(rated);
        CheckBox small = new CheckBox(this); small.setText("حجم کم"); root.addView(small);

        Button search = new Button(this);
        search.setText("جست‌وجو در کافه‌بازار");
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, -2);
        bp.setMargins(0, 18, 0, 14);
        root.addView(search, bp);
        search.setOnClickListener(v -> {
            String q = query.getText().toString().trim();
            if (q.isEmpty()) { query.setError("موضوع برنامه را بنویس"); return; }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafebazaar.ir/search?q=" + Uri.encode(q)));
            startActivity(intent);
        });

        TextView note = new TextView(this);
        note.setText("نسخهٔ آزمایشی\nفعلاً جست‌وجو در سایت رسمی کافه‌بازار باز می‌شود. گزینه‌های فیلتر هنوز به داده‌های واقعی برنامه‌ها وصل نشده‌اند و این نسخه فهرست ۱۰تایی یا رتبه‌بندی خودکار تولید نمی‌کند.");
        note.setTextSize(14);
        note.setTextColor(Color.rgb(90,95,105));
        note.setPadding(14, 14, 14, 14);
        note.setBackgroundColor(Color.rgb(232,239,249));
        root.addView(note, new LinearLayout.LayoutParams(-1,-2));
        setContentView(root);
    }
}
