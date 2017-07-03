package ru.cabanov.artclicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View game;
    private ImageView monster;
    private TextView moneyT;
    private int hp=5, damage=0, money=0;
    private Random rnd = new Random();
    private int[] parts = {R.id.part11, R.id.part12, R.id.part13, R.id.part14, R.id.part15, R.id.part16, R.id.part17, R.id.part18,
            R.id.part21, R.id.part22, R.id.part23, R.id.part24, R.id.part25, R.id.part26, R.id.part27, R.id.part28,
            R.id.part31, R.id.part32, R.id.part33, R.id.part34, R.id.part35, R.id.part36, R.id.part37, R.id.part38,
            R.id.part41, R.id.part42, R.id.part43, R.id.part44, R.id.part45, R.id.part46, R.id.part47, R.id.part48};
    private int[] monsters = {R.drawable.monster, R.drawable.monster2, R.drawable.monster3, R.drawable.monster4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullScreencall();
        setImage();

        moneyT = (TextView) findViewById(R.id.money);
        moneyT.setText("0");

        monster = (ImageView) findViewById(R.id.monster);
        setMonster();

        game = findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                damage++;
                monster.setAlpha(1.0f - (float)damage/hp);

                if(parts.length>0 && damage==hp) {
                    money+=0.5*hp;
                    moneyT.setText( String.valueOf(money) );
                    setMonster();

                    if(rnd.nextFloat()<=0.3) {
                        int i = rnd.nextInt(parts.length);
                        View image = findViewById(parts[i]);
                        image.setVisibility(View.VISIBLE);
                        removePart(i);

                        if(parts.length%4==0) hp++;
                    }
                }
            }
        });
    }

    private void setImage() {

        Bitmap source = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        Bitmap part;
        ImageView image;

        //Первая строка

        image = (ImageView) findViewById(R.id.part11);
        part = Bitmap.createBitmap(source, 0, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part12);
        part = Bitmap.createBitmap(source, 160, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part13);
        part = Bitmap.createBitmap(source, 320, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part14);
        part = Bitmap.createBitmap(source, 480, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part15);
        part = Bitmap.createBitmap(source, 640, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part16);
        part = Bitmap.createBitmap(source, 800, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part17);
        part = Bitmap.createBitmap(source, 960, 0, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part18);
        part = Bitmap.createBitmap(source, 1120, 0, 160, 180);
        image.setImageBitmap(part);

        //Вторая строка

        image = (ImageView) findViewById(R.id.part21);
        part = Bitmap.createBitmap(source, 0, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part22);
        part = Bitmap.createBitmap(source, 160, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part23);
        part = Bitmap.createBitmap(source, 320, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part24);
        part = Bitmap.createBitmap(source, 480, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part25);
        part = Bitmap.createBitmap(source, 640, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part26);
        part = Bitmap.createBitmap(source, 800, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part27);
        part = Bitmap.createBitmap(source, 960, 180, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part28);
        part = Bitmap.createBitmap(source, 1120, 180, 160, 180);
        image.setImageBitmap(part);

        //Третья строка

        image = (ImageView) findViewById(R.id.part31);
        part = Bitmap.createBitmap(source, 0, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part32);
        part = Bitmap.createBitmap(source, 160, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part33);
        part = Bitmap.createBitmap(source, 320, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part34);
        part = Bitmap.createBitmap(source, 480, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part35);
        part = Bitmap.createBitmap(source, 640, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part36);
        part = Bitmap.createBitmap(source, 800, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part37);
        part = Bitmap.createBitmap(source, 960, 360, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part38);
        part = Bitmap.createBitmap(source, 1120, 360, 160, 180);
        image.setImageBitmap(part);

        //Четвёртая строка

        image = (ImageView) findViewById(R.id.part41);
        part = Bitmap.createBitmap(source, 0, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part42);
        part = Bitmap.createBitmap(source, 160, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part43);
        part = Bitmap.createBitmap(source, 320, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part44);
        part = Bitmap.createBitmap(source, 480, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part45);
        part = Bitmap.createBitmap(source, 640, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part46);
        part = Bitmap.createBitmap(source, 800, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part47);
        part = Bitmap.createBitmap(source, 960, 540, 160, 180);
        image.setImageBitmap(part);

        image = (ImageView) findViewById(R.id.part48);
        part = Bitmap.createBitmap(source, 1120, 540, 160, 180);
        image.setImageBitmap(part);
    }

    private void setMonster() {
        int i = rnd.nextInt(monsters.length);
        monster.setImageResource(monsters[i]);
        damage = 0;
        monster.setAlpha(1.0f);
    }

    private void removePart(int i) {
        int[] copy = new int[parts.length - 1];
        System.arraycopy(parts, 0, copy, 0, i);
        System.arraycopy(parts, i + 1, copy, i, parts.length - i - 1);
        parts = copy;
    }

    private void fullScreencall() {
        if(Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if(Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
