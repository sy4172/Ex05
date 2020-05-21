package com.example.ex05;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    WebView viewer;
    String part1, part2, part3, fullUrl, strA, strB, strC, space, result;
    double a, b, c;
    EditText eT1,eT2,eT3;
    boolean flag, flag1, flag2, flag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewer = findViewById(R.id.viewer);
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
        part1 = "https://www.google.com/search?hl=iw&source=hp&ei=w22tXvf8NMmUlwS9hoUo&q=";
        part2 = "&oq=";
        part3 = "&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgQIABAeMgQIABAeOgUIABCDAToGCAAQBxAeOgQIABADOggIABAIEAcQHjoICAAQBxAFEB46BggAEAUQHjoKCAAQBxAFEAoQHjoGCAAQCBAeUJQgWPj4BGCMggVoFnAAeAGAAbMBiAGOH5IBBTI3LjE3mAEAoAEBqgEHZ3dzLXdperABAA&sclient=psy-ab&ved=0ahUKEwi36oeBnZXpAhVJyoUKHT1DAQUQ4dUDCAc&uact=5";
        space = "%";
        viewer.getSettings().setJavaScriptEnabled(true);
        viewer.setWebViewClient(new MyWebViewClient());
    }

    public void check(View view) {
        strA = eT1.getText().toString();
        strB = eT2.getText().toString();
        strC = eT3.getText().toString();

        if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        else{
            flag = true;
        }

        if (strA.equals("0") || strA.equals("-0")){
            Toast.makeText(this, "The parameter A should be bigger or smaller than zero. Try again.", Toast.LENGTH_SHORT).show();
            flag1 = false;
        }
        else{
            flag1 = true;
        }

        if(strA.equals("0.0")|| strA.equals(".0") || strB.equals("0.0") || strB.equals("-0") || strB.equals(".0") || strC.equals("0.0") || strC.equals("-0") || strC.equals(".0")){
            Toast.makeText(this, "Try again.", Toast.LENGTH_SHORT).show();
            flag2 = false;
        }
        else{
            flag2 = true;
        }

        if (strA.endsWith("-") || strA.endsWith(".") || strB.endsWith("-") || strB.endsWith(".") || strC.endsWith("-") || strC.endsWith(".")){
            Toast.makeText(this, "Try again.", Toast.LENGTH_SHORT).show();
            flag3 = false;
        }
        else{
            flag3 = true;
        }

        if (flag && flag1 && flag2 && flag3) {
            a = Double.parseDouble(strA);
            b = Double.parseDouble(strB);
            c = Double.parseDouble(strC);
            result = buildUrl(a,b,c,space);
            fullUrl = part1 + result + part2 + result + part3;
            viewer.loadUrl(fullUrl);
        }
    }

    private String buildUrl(double a, double b, double c, String space) {
        String square, url, newB, newC;
        square = "5E2";
        url = "";

        if (b > 0){
            newB = space+"2B"+b;
        }
        else{
            b = Math.abs(b);
            newB = space+"2D"+b;
        }

        if(c > 0){
            newC = space+"2B"+c;
        }
        else{
            c = Math.abs(c);
            newC = space+"2D"+c;
        }

        if (a == 1){
            if (b == 0){
                if (c == 0){
                    url = "x"+space+square;
                }
                else{
                    url = "x"+space+square+newC;
                }
            }
            else if (b == 1){
                if (c == 0){
                    url = "x"+space+square+space+"2B"+"x";
                }
                else{
                    url = "x"+space+square+space+"2B"+"x"+newC;
                }
            }
            else if (b != 1){
                if (c == 0){
                    url = "x"+space+square+newB+"x";
                }
                else{
                    url = "x"+space+square+newB+"x"+newC;
                }
            }
        }
        else{
            if (b == 0){
                if (c == 0){
                    url = a+"x"+space+square;
                }
                else{
                    url = a+"x"+space+square+newC;
                }
            }
            else if (b == 1){
                if (c == 0){
                    url = a+"x"+space+square+space+"2B"+"x";
                }
                else{
                    url = a+"x"+space+square+space+"2B"+"x"+newC;
                }
            }
            else if (b != 1){
                if (c == 0){
                    url = a+"x"+space+square+newB+"x";
                }
                else{
                    url = a+"x"+space+square+newB+"x"+newC;
                }
            }
        }

        return url;
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}