package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView viewer;
    String url, part1, part2, part3, fullUrl, str1, str2, str3, b, c, space;
    EditText eT1;
    EditText eT2;
    EditText eT3;
    Button show;
    boolean flag, flag1, flag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewer = findViewById(R.id.viewer);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
        show = findViewById(R.id.show);
        flag = flag1 = flag2 = false;
        part1 = "https://www.google.com/search?hl=iw&source=hp&ei=w22tXvf8NMmUlwS9hoUo&q=";
        part2 = "&oq=";
        part3 = "&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgQIABAeMgQIABAeOgUIABCDAToGCAAQBxAeOgQIABADOggIABAIEAcQHjoICAAQBxAFEB46BggAEAUQHjoKCAAQBxAFEAoQHjoGCAAQCBAeUJQgWPj4BGCMggVoFnAAeAGAAbMBiAGOH5IBBTI3LjE3mAEAoAEBqgEHZ3dzLXdperABAA&sclient=psy-ab&ved=0ahUKEwi36oeBnZXpAhVJyoUKHT1DAQUQ4dUDCAc&uact=5";
        space = "%";
        viewer.getSettings().setJavaScriptEnabled(true);
        viewer.setWebViewClient(new MyWebViewClient());
    }

    public void check(View view) {
        str1 = eT1.getText().toString();
        str2 = eT2.getText().toString();
        str3 = eT3.getText().toString();

        if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        else{
            flag = true;
        }

        if (str1.equals("0") || str1.equals("-0")){
            Toast.makeText(this, "The parameter a should be bigger or smaller than zero. Try again.", Toast.LENGTH_SHORT).show();
            flag1 = false;
        }
        else{
            flag1 = true;
        }

        if (str1.endsWith("-") || str1.endsWith(".")  || str2.endsWith("-") || str2.endsWith(".") || str3.endsWith("-") || str3.endsWith(".")){
            Toast.makeText(this, "Try again.", Toast.LENGTH_SHORT).show();
            flag2 = false;
        }
        else{
            flag2 = true;
        }


        if (!(str2.startsWith("-"))) {
            if (str2.endsWith("1")){
                b = space+"2B";
            }
            else{
                b = space+"2B"+str2;
            }
        }
        else{
            if (str2.endsWith("1")){
                b = "";
            }
            else {
                b = str2;
            }
        }

        if (!(str3.startsWith("-"))) {
            c = space+"2B"+str3;
        }
        else{
            c = str3;
        }

        if (flag && flag1 && flag2) {
            fullUrl = buildUrl(str1,b,c,space);
            url = part1 + fullUrl + part2 + fullUrl + part3;
            viewer.loadUrl(url);
        }
    }

    private String buildUrl(String str1, String b, String c, String space) {
        String square, fullUrl;
        square = "5E2";


        if (str1.endsWith("1")){
            if (b.endsWith("0") && c.endsWith("0")){
                fullUrl = "x"+space+square;
            }
            else if (b.endsWith("1") && c.endsWith("0")){
                fullUrl = "x"+space+square+b+"x";
            }
            else if (b.endsWith("1")){
                fullUrl = "x"+space+square+b+"x"+c;
            }
            else if (b.endsWith("0")){
                fullUrl = "x"+space+square+c;
            }
            else if (c.endsWith("0")){
                fullUrl = "x"+space+square+b+"x";
            }
            else{
                fullUrl = "x"+space+square+b+"x"+c;
            }
        }
        else{
            if (b.endsWith("0") && c.endsWith("0")){
                fullUrl = str1+"x"+space+square;
            }
            else if (b.endsWith("1") && c.endsWith("0")){
                fullUrl = str1+"x"+space+square+"x";
            }
            else if (b.endsWith("1")){
                fullUrl = str1+"x"+space+square+"x"+c;
            }
            else if (b.endsWith("0")){
                fullUrl = str1+"x"+space+square+c;
            }
            else if (c.endsWith("0")){
                fullUrl = str1+"x"+space+square+b+"x";
            }
            else{
                fullUrl = str1+"x"+space+square+b+"x"+c;
            }
        }

        return fullUrl;
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
