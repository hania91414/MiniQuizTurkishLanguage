package com.example.hanna.miniquizturkishlanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView view = findViewById(R.id.WebView1);
        String text;
        text = "<html><body><p align=\"justify\">Bildiğin gibi, eşimin işi dolayısıyla geçen hafta başka bir semte taşındık. Onun için sana ancak şimdi e-posta <font color=#673AB7>__<b><u>A</u></b>__</font>. Şimdiki evimiz 160 m<sup>2</sup>; kocaman salonu, güzel bir bahçesi, çift balkonu <font color=#673AB7>__<b><u>B</u></b>__</font> aydınlık ve manzaralı bir ev. Taşınma günü sabahı nakliyat firması erkenden geldi.</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = findViewById(R.id.WebView2);
        String text2;
        text2 = "<html><body><p align=\"justify\">Biliyorsun, fotoğrafçılar için sonbaharın yeri ayrıdır; çünkü gün ışığının <font color=#673AB7>__<b><u>C</u></b>__</font> güzel mevsimidir. Böyle düşündüğüm için ben <font color=#673AB7>__<b><u>D</u></b>__</font> fırsatı kaçırmayıp Kapadokya’da balon turuna çıktım.</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = findViewById(R.id.WebView3);
        String text3;
        text3 = "<html><body><p align=\"justify\">Sayın yolcularımız, emniyetiniz için mutlaka bagaj kurallarımıza uymanızı rica ederiz! Özel kafeslerindeki kedi, köpek ve kuş gibi evcil hayvanlar sadece bagaj taşımaya mahsus bölümlerde taşınabilir. Tehlike yaratabilecek yanıcı, yakıcı, patlayıcı ve benzeri nitelikte eşya, kargo ve bagajlar, bagaj bölümü de dâhil olmak üzere otobüsle taşınamaz!</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        WebView view4 = findViewById(R.id.WebView4);
        String text4;
        text4 = "<html><body><p align=\"justify\">Sayın müşterilerimiz, inanılmaz indirimler var! Tatlı, şeker ve çikolatalarda cazip indirim ve ödeme seçenekleri alt kata sizleri bekliyor. Ancak bugün geçerli olan indirimler stoklar tükendiği an geçerliliğini kaybedecektir, yani acele etmeniz gerekiyor!</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");
    }

    public void submitAnswer(View view) {
        CheckBox CheckBox1 = findViewById(R.id.checkbox1);
        boolean isChosenCheckBox1 = CheckBox1.isChecked();

        CheckBox CheckBox2 = findViewById(R.id.checkbox2);
        boolean isChosenCheckBox2 = CheckBox2.isChecked();

        CheckBox CheckBox3 = findViewById(R.id.checkbox3);
        boolean isChosenCheckBox3 = CheckBox3.isChecked();

        RadioButton RadioButton1 = findViewById(R.id.radio_button_q1a1);
        boolean isChosenRadioButton1 = RadioButton1.isChecked();

        RadioButton RadioButton2 = findViewById(R.id.radio_button_q1a2);
        boolean isChosenRadioButton2 = RadioButton2.isChecked();

        RadioButton RadioButton3 = findViewById(R.id.radio_button_q1a3);
        boolean isChosenRadioButton3 = RadioButton3.isChecked();

        RadioButton RadioButton4 = findViewById(R.id.radio_button_q2a1);
        boolean isChosenRadioButton4 = RadioButton4.isChecked();

        RadioButton RadioButton5 = findViewById(R.id.radio_button_q2a2);
        boolean isChosenRadioButton5 = RadioButton5.isChecked();

        RadioButton RadioButton6 = findViewById(R.id.radio_button_q2a3);
        boolean isChosenRadioButton6 = RadioButton6.isChecked();

        EditText questionCanswerView = findViewById(R.id.textAnswerC);
        String answerC = questionCanswerView.getText().toString();

        EditText questionDanswerView = findViewById(R.id.textAnswerD);
        String answerD = questionDanswerView.getText().toString();

        int finalScore = calculateScore(isChosenCheckBox1, isChosenCheckBox2, isChosenCheckBox3,
                isChosenRadioButton1,isChosenRadioButton2, isChosenRadioButton3,
                isChosenRadioButton4, isChosenRadioButton5, isChosenRadioButton6, answerC, answerD);

        Toast.makeText(this, "Your score is " + finalScore + " points", Toast.LENGTH_SHORT).show();

    }


    private int calculateScore(boolean chooseCheckBox1, boolean chooseCheckBox2, boolean chooseCheckBox3, boolean chooseRadioButton1,
                               boolean chooseRadioButton2, boolean chooseRadioButton3, boolean chooseRadioButton4, boolean chooseRadioButton5, boolean chooseRadioButton6,
                               String givenAnswerForC, String givenAnswerForD) {
        int question1ResultA = 0;

        if (chooseRadioButton1) {question1ResultA = 1;}
        if (chooseRadioButton2) {question1ResultA = 0;}
        if (chooseRadioButton3) {question1ResultA = 0;}

        int question1ResultB =0;

        if (chooseRadioButton4) {question1ResultB = 1;}
        if (chooseRadioButton5) {question1ResultB = 0;}
        if (chooseRadioButton6) {question1ResultB = 0;}

        int question2ResultC;
        String correctAnswerC1 = "en";
        String correctAnswerC2 = "En";
        if (givenAnswerForC.equals(correctAnswerC1)) {
            question2ResultC = 1;
        } else if (givenAnswerForC.equals(correctAnswerC2)){
            question2ResultC = 1;
        } else {question2ResultC = 0;}

        int question2ResultD;
        String correctAnswerD1 = "de";
        String correctAnswerD2 = "De";
        if (givenAnswerForD.equals(correctAnswerD1)) {
            question2ResultD = 1;
        } else if (givenAnswerForD.equals(correctAnswerD2)){
            question2ResultD = 1;
        } else {question2ResultD = 0;}

        int question3result = 0;

        if (chooseCheckBox1) {
            question3result = 0;
        } else if (chooseCheckBox2) {question3result =1;
            if (chooseCheckBox3) {
                question3result = 0;}
        }else {question3result =0;}
        
        return  question3result + question1ResultA + question1ResultB + question2ResultC + question2ResultD;

    }
}

