package yasinaydin.donusturucu;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tw;
    TextView tw2;
    TextView tw3;
    TextView tw4;
    TextView tw5;
    TextView tw6;
    char[] karakter={};
    char[] ascii={};
    String karak;
    int[] deger={};
    char[][] octa={};
    char[] hexa={};
    char[][] hexaa={};
    String[] binary={};
    String[] hex={};
    String[] oct={};
    String asc;
    String hexxx;
    int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,r,t,u,v,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak;
    boolean dogru;
    Context ctx=MainActivity.this;
    String[] dec={};
    String[] hexx={"A","B","C","D","E","F"};
    ArrayAdapter<String> la;
    ListView lw;
    ArrayList<String> ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
        tw = (TextView) findViewById(R.id.textView);
        tw2 = (TextView) findViewById(R.id.textView2);
        tw3 = (TextView) findViewById(R.id.textView3);
        tw4 = (TextView) findViewById(R.id.textView4);
        tw5 = (TextView) findViewById(R.id.textView5);
        tw6 = (TextView) findViewById(R.id.textView6);
        lw=(ListView) findViewById(R.id.lw);
        ls=new ArrayList<String>();
        ls.add("ASCII");
        ls.add("Binary");
        ls.add("Decimal");
        ls.add("Hexadecimal");
        ls.add("Octal");
        la=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ls);
        lw.setAdapter(la);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                r=position;
                if(position==0){
                    tw6.setText("   ASCII");
                }
                if(position==1){
                    tw6.setText("   Binary");
                }
                if(position==2){
                    tw6.setText("   Decimal");
                }
                if(position==3){
                    tw6.setText("   Hexadecimal");
                }
                if(position==4){
                    tw6.setText("   Octal");
                }
                et.setText(et.getText().toString());
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(r==0) {
                    karak = s.toString();
                    karakter = karak.toCharArray();
                    u=karak.length();
                    deger = new int[karak.length()];
                    l = 0;
                    for (int i = 0; i < karak.length(); i++) {
                        a = karakter[i];
                        deger[i] = a;
                        if (a < 256) {
                            if (a > (-1)) {
                                l++;
                            }
                        }
                    }
                }
                if(r==1){
                    karak=s.toString();
                    karakter=karak.toCharArray();
                    af=0;
                    for(i=0;i<karak.length();i++){
                        if(karakter[i]==32||karakter[i]==10){
                            for(ag=i;ag<(karak.length()-af)-1;ag++){
                                karakter[ag]=karakter[ag+1];
                            }
                            i=i-1;
                            for(ag=(karak.length()-af)-1;ag<karak.length();ag++){
                                karakter[ag]='\0';
                            }
                            af++;
                        }
                    }
                    hexa = new char[karak.length()-af];
                    for(i=0;i<karak.length()-af;i++) {
                        hexa[i] = karakter[i];
                    }
                    hexxx=new String(hexa);
                    if(hexxx.length()%8==0){
                        hexaa=new char[hexxx.length()/8][8];
                        for(ah=0;ah<hexxx.length()/8;ah++){
                            for(aj=0;aj<8;aj++){
                                hexaa[ah][aj]=hexa[8*ah+aj];
                            }
                        }
                        deger=new int[hexxx.length()/8];
                        for(ah=0;ah<hexxx.length()/8;ah++){
                            ak=128;
                            ai=0;
                            for(aj=0;aj<8;aj++){
                                if(hexaa[ah][aj]<50&&hexaa[ah][aj]>47){
                                    ai=ai+(hexaa[ah][aj]-48)*ak;
                                }
                                ak=ak/2;
                            }
                            deger[ah]=ai;
                        }
                        u=hexxx.length()/8;
                        l=hexxx.length()/8;
                    }
                    else{
                        l=0;
                        u=1;
                    }
                }
                if(r==2){
                    karak = s.toString();
                    karakter = karak.toCharArray();
                    t=0;
                    v=0;
                    y=0;
                    dec=new String[karak.length()];
                    for(i=0;i<karak.length();i++){
                        if(karakter[i]==32||karakter[i]==10){
                            t++;
                        }
                        else{
                            if(karakter[i]<58&&karakter[i]>47) {
                                if(t>0){
                                    t=0;
                                    if(y==1) {
                                        v++;
                                    }
                                }
                                if (dec[v] != null) {
                                    dec[v] = (dec[v] + karakter[i]);
                                }
                                if (dec[v] == null) {
                                    dec[v] = ("" + karakter[i]);
                                }
                                y=1;
                            }
                        }
                    }
                    deger=new int[v+1];
                    l=0;
                    u=v+1;
                    for(i=0;i<=v;i++){
                        if(!(s.toString().equals(""))) {
                            if (dec[i] != null&&!(dec[i].equals(""))) {
                                deger[i] = Integer.parseInt(dec[i]);
                                if (deger[i] < 256) {
                                    if (deger[i] > (-1)) {
                                        l++;
                                    }
                                }
                            }
                        }
                        else{
                            l=1;
                        }
                    }
                }
                if(r==3){
                    karak=s.toString();
                    karakter=karak.toCharArray();
                    af=0;
                    for(i=0;i<karak.length();i++){
                        if(karakter[i]==32||karakter[i]==10){
                            for(ag=i;ag<(karak.length()-af)-1;ag++){
                                karakter[ag]=karakter[ag+1];
                            }
                            i=i-1;
                            for(ag=(karak.length()-af)-1;ag<karak.length();ag++){
                                karakter[ag]='\0';
                            }
                            af++;
                        }
                    }
                    hexa = new char[karak.length()-af];
                    for(i=0;i<karak.length()-af;i++) {
                        hexa[i] = karakter[i];
                    }
                    hexxx=new String(hexa);
                    if(hexxx.length()%2==0){
                        hexaa=new char[hexxx.length()/2][2];
                        for(ah=0;ah<hexxx.length()/2;ah++){
                            for(aj=0;aj<2;aj++){
                                //65  70  97 102
                                hexaa[ah][aj]=hexa[2*ah+aj];
                            }
                        }
                        deger=new int[hexxx.length()/2];
                        for(ah=0;ah<hexxx.length()/2;ah++){
                            ak=16;
                            ai=0;
                            for(aj=0;aj<2;aj++){
                                if(hexaa[ah][aj]<58&&hexaa[ah][aj]>47){
                                    ai=ai+(hexaa[ah][aj]-48)*ak;
                                }
                                else if(hexaa[ah][aj]<71&&hexaa[ah][aj]>64){
                                    ai=ai+(hexaa[ah][aj]-55)*ak;
                                }
                                else if(hexaa[ah][aj]<103&&hexaa[ah][aj]>96){
                                    ai=ai+(hexaa[ah][aj]-87)*ak;
                                }
                                ak=1;
                            }
                            deger[ah]=ai;
                        }
                        u=hexxx.length()/2;
                        l=hexxx.length()/2;
                    }
                    else{
                        l=0;
                        u=1;
                    }
                }
                if(r==4){
                    karak=s.toString();
                    karakter=karak.toCharArray();
                    t=0;
                    v=0;
                    y=0;
                    dec=new String[karak.length()];
                    for(i=0;i<karak.length();i++){
                        if(karakter[i]==32||karakter[i]==10){
                            t++;
                        }
                        else{
                            if(karakter[i]<56&&karakter[i]>47) {
                                if(t>0){
                                    t=0;
                                    if(y==1) {
                                        v++;
                                    }
                                }
                                if (dec[v] != null) {
                                    dec[v] = (dec[v] + karakter[i]);
                                }
                                if (dec[v] == null) {
                                    dec[v] = ("" + karakter[i]);
                                }
                                y=1;
                            }
                        }
                    }
                    deger=new int[v+1];
                    octa=new char[v+1][3];
                    l=0;
                    u=v+1;
                    for(i=0;i<=v;i++){
                        if(!(s.toString().equals(""))) {
                            if (dec[i] != null&&!(dec[i].equals(""))) {
                                octa[i] = dec[i].toCharArray();
                                ae=Integer.parseInt(dec[i]);
                                aa=ae%100;
                                ab=ae/100;
                                ac=aa/10;
                                ad=aa%10;
                                z=(ab*64)+(ac*8)+ad;
                                deger[i]=z;
                                if (deger[i] < 256) {
                                    if (deger[i] > (-1)) {
                                        l++;
                                    }
                                }
                            }
                        }
                        else{
                            l=1;
                        }
                    }
                }
                if(l==u) {
                    tw3.setText("Decimal : ");
                    for (int i = 0; i < u; i++) {
                        tw3.append(deger[i] + " ");
                    }
                    tw.setText("ASCII : ");
                    ascii=new char[u];
                    for(i=0;i<u;i++){
                        ascii[i]=(char)deger[i];
                    }
                    asc=new String(ascii);
                    tw.append(asc);
                    tw2.setText("Binary :");
                    binary = new String[u];
                    for (i = 0; i < u; i++) {
                        b = 1;
                        c = deger[i];
                        d = 0;
                        e = 0;
                        dogru = true;
                        while (dogru) {
                            b = b * 2;
                            if (b >= c) {
                                f = (7 - e) - d;
                                if (b == c) {
                                    f = f - 1;
                                }
                                if (f > 0) {
                                    for (int k = 0; k < f; k++) {
                                        if (binary[i] != null) {
                                            binary[i] = (binary[i] + "0");
                                        }
                                        if (binary[i] == null) {
                                            binary[i] = ("0");
                                        }
                                    }
                                }
                                if(c>0) {
                                    if(binary[i]==null){
                                        binary[i]=("1");
                                    }
                                    else {
                                        binary[i] = (binary[i] + "1");
                                    }
                                }
                                if (c == b) {
                                    g = b;
                                }
                                if (c != b) {
                                    g = b / 2;
                                }
                                c = c - g;
                                b = 1;
                                e = -1;
                                d = f + 1 + d;
                            }
                            e++;
                            if (e == 8) {
                                dogru = false;
                            }
                            if (c < 1) {
                                if (binary[i].length() < 8) {
                                    for (int l = binary[i].length(); l < 8; l++) {
                                        binary[i] = (binary[i] + "0");
                                    }
                                }
                                dogru = false;
                            }
                        }
                        tw2.append(binary[i] + " ");
                    }
                    tw4.setText("Hexadecimal :");
                    hex = new String[u];
                    for (i = 0; i < u; i++) {
                        h = deger[i];
                        j = h % 16;
                        k = h / 16;
                        if (k > 9 && k < 16) {
                            hex[i] = (hexx[k - 10]);
                        } else {
                            hex[i] = ("" + k);
                        }
                        if (j > 9 && j < 16) {
                            hex[i] = (hex[i] + hexx[j - 10]);
                        } else {
                            hex[i] = (hex[i] + "" + j);
                        }
                        tw4.append(" " + hex[i]);
                    }
                    tw5.setText("Octal :");
                    oct=new String[u];
                    for (i=0;i<u;i++){
                        m=deger[i];
                        n=m/64;
                        o=(m%64)/8;
                        p=(m%64)%8;
                        if(o>0){
                            if(n>0){
                                oct[i]=(""+n+o+p);
                            }
                            else{
                                oct[i]=(""+o+p);
                            }
                        }
                        else{
                            if(n>0){
                                oct[i]=(""+n+o+p);
                            }
                            else {
                                oct[i] = ("" + p);
                            }
                        }
                        tw5.append(" "+oct[i]);
                    }
                }
                else{

                }
            }
        });
    }
}

