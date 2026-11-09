package com.sander.deflect.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Dashboard extends LinearLayout {

    public TextView tvBanner;
    public TextView tvLog;
    public ScrollView scrollLog;
    public Button btnRecon, btnDecoy, btnSocket, btnStop, btnClear;

    public Dashboard(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.BLACK);

        tvBanner = new TextView(context);
        tvBanner.setTypeface(Typeface.MONOSPACE);
        tvBanner.setTextColor(Color.parseColor("#00FFFF"));
        tvBanner.setTextSize(10);
        tvBanner.setPadding(20, 20, 20, 10);
        tvBanner.setText(
            "  ____                 _   ____       _      _     _ \n" +
            " / ___|  __ _ _ __   __| | |  _ \\  ___| | ___| |__ | |\n" +
            " \\___ \\ / _` | '_ \\ / _` | | | | |/ _ \\ |/ _ \\ '_ \\| |\n" +
            "  ___) | (_| | | | | (_| | | |_| |  __/ |  __/ | | | |\n" +
            " |____/ \\__,_|_| |_|\\__,_| |____/ \\___|_|\\___|_| |_|_|\n" +
            "                     [ v1.0 DASHBOARD ]\n" +
            "                     user@sander:~$"
        );
        addView(tvBanner, new LayoutParams(-1, -2));

        GridLayout grid = new GridLayout(context);
        grid.setColumnCount(2);
        grid.setPadding(20, 10, 20, 10);

        btnRecon = createBtn(context, "[ RECON ]", "#00FF00");
        btnDecoy = createBtn(context, "[ DECOY ]", "#FF0000");
        btnSocket = createBtn(context, "[ SOCKET ]", "#FFFF00");
        btnStop = createBtn(context, "[ STOP ]", "#FF8800");
        btnClear = createBtn(context, "[ CLEAR ]", "#00FFFF");

        grid.addView(btnRecon);
        grid.addView(btnDecoy);
        grid.addView(btnSocket);
        grid.addView(btnStop);
        grid.addView(btnClear);

        addView(grid, new LayoutParams(-1, -2));

        scrollLog = new ScrollView(context);
        tvLog = new TextView(context);
        tvLog.setTypeface(Typeface.MONOSPACE);
        tvLog.setTextColor(Color.parseColor("#00FFFF"));
        tvLog.setTextSize(11);
        tvLog.setPadding(20, 20, 20, 20);
        scrollLog.addView(tvLog);
        addView(scrollLog, new LayoutParams(-1, 0, 1.0f));
    }

    private Button createBtn(Context context, String text, String colorHex) {
        Button btn = new Button(context);
        btn.setText(text);
        btn.setTypeface(Typeface.MONOSPACE);
        btn.setTextColor(Color.parseColor(colorHex));
        btn.setBackgroundColor(Color.parseColor("#111111"));
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = -2;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        params.setMargins(5, 5, 5, 5);
        btn.setLayoutParams(params);
        return btn;
    }
}
