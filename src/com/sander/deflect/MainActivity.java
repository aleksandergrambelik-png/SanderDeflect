package com.sander.deflect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.sander.deflect.func.DeflectHttp;
import com.sander.deflect.func.DeflectDecoy;
import com.sander.deflect.func.DeflectSocket;
import com.sander.deflect.support.SanderThread;

public class MainActivity extends Activity {

    TextView tvTerminal;
    EditText inputTerminal;
    ScrollView terminalScroll;
    Handler handler = new Handler(Looper.getMainLooper());

    int colorCyan = Color.parseColor("#00FFFF");
    int colorGreen = Color.parseColor("#00FF00");
    int colorRed = Color.parseColor("#FF0000");
    int colorWhite = Color.parseColor("#FFFFFF");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.BLACK);

        terminalScroll = new ScrollView(this);
        tvTerminal = new TextView(this);
        tvTerminal.setTypeface(Typeface.MONOSPACE);
        tvTerminal.setTextColor(colorCyan);
        tvTerminal.setTextSize(12);
        tvTerminal.setPadding(20, 20, 20, 20);
        terminalScroll.addView(tvTerminal);
        mainLayout.addView(terminalScroll, new LinearLayout.LayoutParams(-1, 0, 1.0f));

        inputTerminal = new EditText(this);
        inputTerminal.setHint("$ command... (help)");
        inputTerminal.setTypeface(Typeface.MONOSPACE);
        inputTerminal.setTextColor(colorGreen);
        inputTerminal.setHintTextColor(Color.GRAY);
        inputTerminal.setBackgroundColor(Color.parseColor("#111111"));
        inputTerminal.setPadding(20, 20, 20, 20);
        inputTerminal.setSingleLine(true);
        inputTerminal.setImeOptions(EditorInfo.IME_ACTION_DONE);

        inputTerminal.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, android.view.KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String cmd = inputTerminal.getText().toString().trim();
                    if (!cmd.isEmpty()) {
                        executeCommand(cmd);
                        inputTerminal.setText("");
                    }
                    return true;
                }
                return false;
            }
        });
        mainLayout.addView(inputTerminal, new LinearLayout.LayoutParams(-1, -2));

        setContentView(mainLayout);

        appendLog("===================================", colorCyan);
        appendLog("      SANDER DEFLECT v1.0          ", colorCyan);
        appendLog("===================================", colorCyan);
        appendLog("Type 'help' for command list.\n", colorGreen);

        showMathChallenge();
    }

    private void showMathChallenge() {
        java.util.Random rand = new java.util.Random();
        int a = rand.nextInt(20) + 1;
        int b = rand.nextInt(20) + 1;
        int operator = rand.nextInt(3);
        String opSymbol = "";
        int correctAnswer = 0;

        if (operator == 0) { opSymbol = "+"; correctAnswer = a + b; }
        else if (operator == 1) { opSymbol = "-"; correctAnswer = a - b; }
        else { opSymbol = "*"; correctAnswer = a * b; }

        String question = a + " " + opSymbol + " " + b + " = ?";

        final android.widget.EditText input = new android.widget.EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint("Enter answer");
        input.setTextColor(Color.GREEN);
        input.setHintTextColor(Color.GRAY);
        input.setBackgroundColor(Color.BLACK);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SANDER DEFLECT ACCESS");
        builder.setMessage("Prove you are not a script kiddie.\n\n" + question);
        builder.setView(input);
        builder.setCancelable(false);

        final int finalCorrectAnswer = correctAnswer;
        builder.setPositiveButton("UNLOCK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userInput = input.getText().toString().trim();
                if (userInput.equals(String.valueOf(finalCorrectAnswer))) {
                    appendLog("Math correct. Access granted.\n", colorGreen);
                } else {
                    appendLog("Access Denied. Nice try, script kiddie.\n", colorRed);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);
                }
            }
        });
        builder.show();
    }

    private void appendLog(final String text, final int color) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                SpannableString spannable = new SpannableString(text + "\n");
                spannable.setSpan(new ForegroundColorSpan(color), 0, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tvTerminal.append(spannable);
                terminalScroll.post(new Runnable() {
                    @Override
                    public void run() {
                        terminalScroll.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }

    private void executeCommand(String cmdLine) {
        appendLog("root@sander:~# " + cmdLine, colorCyan);
        String[] parts = cmdLine.split("\\s+");
        String cmd = parts[0].toLowerCase();

        if (cmd.equals("help")) {
            appendLog("Commands:", colorGreen);
            appendLog("  http <url>  - Fetch URL", colorGreen);
            appendLog("  decoy       - Show Fake HTML", colorGreen);
            appendLog("  socket      - Start Defense Socket", colorGreen);
            appendLog("  socket_stop - Stop Defense Socket", colorGreen);
            appendLog("  clear       - Clear terminal", colorGreen);
        } else if (cmd.equals("clear")) {
            tvTerminal.setText("");
        } else if (cmd.equals("http") && parts.length > 1) {
            appendLog("> Fetching " + parts[1] + "...", Color.YELLOW);
            SanderThread.start(new Runnable() {
                @Override
                public void run() {
                    String result = DeflectHttp.fetch(MainActivity.this, parts[1]);
                    String formatted = result.replaceAll("<", "\n<")
                                             .replaceAll(">", ">\n")
                                             .replaceAll("\n+", "\n")
                                             .trim();
                    appendLog(formatted, colorWhite);
                }
            });
        } else if (cmd.equals("decoy")) {
            appendLog(DeflectDecoy.getFakeResponse(), colorRed);
        } else if (cmd.equals("socket")) {
            appendLog("> Starting Defense Socket...", Color.YELLOW);
            DeflectSocket.start(MainActivity.this, 8080, new DeflectSocket.Callback() {
                @Override
                public void onLog(String message) {
                    appendLog(message, colorCyan);
                }
            });
        } else if (cmd.equals("socket_stop")) {
            DeflectSocket.stop();
            appendLog("> Socket stopped.", colorRed);
        } else {
            appendLog("sh: " + cmd + ": command not found", colorRed);
        }
    }
}
