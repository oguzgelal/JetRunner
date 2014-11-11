import processing.core.*; 
import processing.xml.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class JetRunner_Game extends PApplet {

float i = 0;
float i2 = 333;
float i3 = 666;
float xr = 250;
float yr = 250;
float wr = 250;
float xr2 = 250;
float yr2 = 250;
float wr2 = 250;
float xr3 = 250;
float yr3 = 250;
float wr3 = 250;
float ucakx = 250;
float ucaky = 250;
float oyunhizi = 2;
float oyunhiziartis = 0;
float ik = 0;
float kutux = width/2;
float kutuy = height/2;
float puan = 0;
float puansalise = 0;

int bonus = 0;
int aktif = 3;
int can = 10;
int ucakboyutw = 120;
int ucakboyuth = 40;
int harekethizi = 15;
int buyuktur = 5000;
int a = 0;
int can1 = 10;

boolean pause;
boolean qbgec;
boolean puanbonus = false;
boolean keyR = false;
boolean keyL = false;
boolean keySP = false;
boolean carp1 = false;
boolean bonuscountbool = false;
boolean puanpause = false;

PImage qb;
PImage qb2;
PImage b;
PImage bonusresim;
PImage bonus1;
PImage bonus2;
PImage bonus3;
PImage bonus4;
PImage bonus5;
PImage bonus6;
PImage bonus7;
PImage bonus8;
PImage bonus9;
PImage bonus10;
PImage menu;




Minim minim;
AudioPlayer bg;
AudioSample carp;
AudioSample blip;
AudioSample death;


public void setup() {
  size (500,500);
  PFont font;
  font = loadFont("00370-48.vlw");
  textFont(font);
  b = loadImage("img/can.png");
  qb = loadImage("img/qb.png");
  qb2 = loadImage("img/qb2.png");
  bonus1 = loadImage("img/b1.png");
  bonus2 = loadImage("img/b2.png");
  bonus3 = loadImage("img/b3.png");
  bonus4 = loadImage("img/b4.png");
  bonus5 = loadImage("img/b5.png");
  bonus6 = loadImage("img/b6.png");
  bonus7 = loadImage("img/b7.png");
  bonus8 = loadImage("img/b8.png");
  bonus9 = loadImage("img/b9.png");
  bonus10 = loadImage("img/b10.png");
  menu = loadImage("img/menu.jpg");

  minim = new Minim(this);

  bg = minim.loadFile("bg.mp3");
  carp = minim.loadSample("carp.wav");
  blip = minim.loadSample("blip.wav");
  death = minim.loadSample("death.mp3");

  bg.loop();
}

public void vertexciz(float x1,float y1,float x2,float y2,float x3,float y3,float x4,float y4,float c) {

  fill(c);
  beginShape();
  vertex(x1,y1);
  vertex(x2,y2);
  vertex(x3,y3);
  vertex(x4,y4);
  endShape();
  noFill();
}

public void oyun() {


  if (puan%1011 == 0) {
    oyunhizi = oyunhizi+4;
  }

  pause = false;

  i = i+oyunhizi+oyunhiziartis;
  if (i > 999) {
    i = 0;
    xr = random(100,400);
    while (((xr - (i / 2)) <= ((xr2 - (i2 / 2))+20)) || ((xr - (i / 2)) >= ((xr2 - (i2 / 2)) + i2-20))) {
      xr = random(100,400);
    }
    yr = random(100,400);
    while (((yr - (i / 2)) <= ((yr2 - (i2 / 2))+20)) || ((yr - (i / 2)) >= ((yr2 - (i2 / 2)) + i2-20))) {
      yr = random(100,400);
    }
    wr = random(200,300);
  }

  i2 = i2+oyunhizi+oyunhiziartis;
  if (i2 > 999) {
    i2 = 0;
    xr2 = random(100,400);
    while (((xr2 - (i2 / 2)) <= ((xr3 - (i3 / 2))+20)) || ((xr2 - (i2 / 2)) >= ((xr3 - (i3 / 2)) + i3-20))) {
      xr2 = random(100,400);
    }
    yr2 = random(100,400);
    while (((yr2 - (i2 / 2)) <= ((yr3 - (i3 / 2))+20)) || ((yr2 - (i2 / 2)) >= ((yr3 - (i3 / 2)) + i3-20))) {
      yr2 = random(100,400);
    }
    wr2 = random(200,300);
  }

  i3 = i3+oyunhizi+oyunhiziartis;
  if (i3 > 999) {
    i3 = 0;
    xr3 = random(100,400);
    while (((xr3 - (i3 / 2)) <= ((xr - (i / 2))+20)) || ((xr3 - (i3 / 2)) >= ((xr - (i / 2)) + i-20))) {
      xr3 = random(100,400);
    }
    yr3 = random(100,400);
    while (((yr3 - (i3 / 2)) <= ((yr - (i / 2))+20)) || ((yr3 - (i3 / 2)) >= ((yr - (i / 2)) + i-20))) {
      yr3 = random(100,400);
    }
    wr3 = random(200,300);
  }




  float xd = xr - (i / 2);
  float yd = yr - (i / 2);
  float xd2 = xr2 - (i2 / 2);
  float yd2 = yr2 - (i2 / 2);
  float xd3 = xr3 - (i3 / 2);
  float yd3 = yr3 - (i3 / 2);
  stroke(0);
  noFill();
  strokeWeight(4);

  float yakinlik;
  float yakinlik2;
  float yakinlik3;

  if ((wr - i) > 0) {
    yakinlik = wr - i;
  }
  else {
    yakinlik = 500;
    if ((ucakx - (ucakboyutw/2) < xd) || (ucakx + (ucakboyutw/2)) > xd + i) {

      carp.trigger();
      ucakx = xd + i/2;
      ucaky = yd + i/2;
      if (can > 1) {
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
        bg.close();
        death.trigger();
      }
    }
    else if ((ucaky - (ucakboyuth/2) < yd) || (ucaky + (ucakboyuth/2)) > yd + i) {

      carp.trigger();
      ucakx = xd + i/2;
      ucaky = yd + i/2;
      if (can > 1) {
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
        bg.close();
        death.trigger();
      }
    }
    else {


      if (ucakx > width) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucakx < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucaky > height) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
      if (ucaky < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
    }
  }

  if ((wr2 - i2) > 0 ) {
    yakinlik2 = wr2 - i2;
  }
  else {
    yakinlik2 = 500;
    if ((ucakx - (ucakboyutw/2) < xd2) || (ucakx + (ucakboyutw/2)) > xd2 + i2) {

      ucakx = xd2 + i2/2;
      ucaky = yd2 + i2/2;
      if (can > 1) {
        carp.trigger();
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
        bg.close();
        death.trigger();
      }
    }
    else if ((ucaky - (ucakboyuth/2) < yd2) || (ucaky + (ucakboyuth/2)) > yd2 + i2) {

      ucakx = xd2 + i2/2;
      ucaky = yd2 + i2/2;
      if (can > 1) {
        carp.trigger();
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
        bg.close();
        death.trigger();
      }
    }
    else {


      if (ucakx > width) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucakx < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucaky > height) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
      if (ucaky < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
    }
  }
  if ((wr3 - i3) > 0 ) {
    yakinlik3 = wr3 - i3;
  }
  else {
    yakinlik3 = 500;
    if ((ucakx - (ucakboyutw/2) < xd3) || (ucakx + (ucakboyutw/2)) > xd3 + i3) {

      ucakx = xd3 + i3/2;
      ucaky = yd3 + i3/2;
      if (can > 1) {
        carp.trigger();
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
        death.trigger();
      }
    }
    else if ((ucaky - (ucakboyuth/2) < yd3) || (ucaky + (ucakboyuth/2)) > yd3 + i3) {

      ucakx = xd2;
      ucaky = yd2;
      if (can > 1) {
        carp.trigger();
        can = can - 1;
        a = 2;
      }
      else {
        a = 3;
        minim.stop();
   bg.close();
        death.trigger();
      }
    }
    else {


      if (ucakx > width) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucakx < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucakx = width/2;
      }
      if (ucaky > height) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
      if (ucaky < 0) {
        if (can > 1) {
          carp.trigger();
          can = can - 1;
          a = 2;
        }
        else {
          a = 3;
          minim.stop();
          bg.close();
          death.trigger();
        }

        ucaky = height/2;
      }
    }
  }
  if (pause == false) {

    float mini = min (i,i2,i3);
    if (mini == i) {
      fill (255);
    }
    else if (mini == i2) {
      fill (255);
    }
    else if (mini == i3) {
      fill(255);
    }


    rect (xd,yd,i,i);
    /*rect (xd+10,yd+10,i-20,i-20);
     line (xd,yd,xd+10,yd+10);
     line (xd,yd+i,xd+10,yd+i-10);
     line (xd+i,yd,xd+i-10,yd+10);
     line (xd+i,yd+i,xd+i-10,yd+i-10);*/
    noFill();


    rect (xd2,yd2,i2,i2);
    /*rect (xd2+10,yd2+10,i2-20,i2-20);
     line (xd2,yd2,xd2+10,yd2+10);
     line (xd2,yd2+i2,xd2+10,yd2+i2-10);
     line (xd2+i2,yd2,xd2+i2-10,yd2+10);
     line (xd2+i2,yd2+i2,xd2+i2-10,yd2+i2-10);*/
    noFill();


    rect (xd3,yd3,i3,i3);
    /*rect (xd3+10,yd3+10,i3-20,i3-20);
     line (xd3,yd3,xd3+10,yd3+10);
     line (xd3,yd3+i3,xd3+10,yd3+i3-10);
     line (xd3+i3,yd3,xd3+i3-10,yd3+10);
     line (xd3+i3,yd3+i3,xd3+i3-10,yd3+i3-10);*/
    noFill();

    float maxi = max (i,i2,i3);

    if (maxi == i) {
      line (xd,yd,xd3,yd3);
      line (xd+i,yd,xd3+i3,yd3);
      line (xd,yd+i,xd3,yd3+i3);
      line (xd+i,yd+i,xd3+i3,yd3+i3);

      vertexciz(xd,yd,xd+i,yd,xd3+i3,yd3,xd3,yd3,200);
      vertexciz(xd3,yd3,xd3+i3,yd3,xd2+i2,yd2,xd2,yd2,200);
      vertexciz(xd+i,yd,xd+i,yd+i,xd3+i3,yd3+i3,xd3+i3,yd3,200);
      vertexciz(xd3+i3,yd3,xd3+i3,yd3+i3,xd2+i2,yd2+i2,xd2+i2,yd2,200);
      vertexciz(xd+i,yd+i,xd,yd+i,xd3,yd3+i3,xd3+i3,yd3+i3,200);
      vertexciz(xd3+i3,yd3+i3,xd3,yd3+i3,xd2,yd2+i2,xd2+i2,yd2+i2,200);
      vertexciz(xd,yd+i,xd,yd,xd3,yd3,xd3,yd3+i3,200);
      vertexciz(xd3,yd3+i3,xd3,yd3,xd2,yd2,xd2,yd2+i2,200);

      line (xd3,yd3,xd2,yd2);
      line (xd3,yd3+i3,xd2,yd2+i2);
      line (xd3+i3,yd3,xd2+i2,yd2);
      line (xd3+i3,yd3+i3,xd2+i2,yd2+i2);
    }
    else if (maxi == i2) {
      line (xd2,yd2,xd,yd);
      line (xd2+i2,yd2,xd+i,yd);
      line (xd2,yd2+i2,xd,yd+i);
      line (xd2+i2,yd2+i2,xd+i,yd+i);

      vertexciz(xd2,yd2,xd2+i2,yd2,xd+i,yd,xd,yd,200);
      vertexciz(xd,yd,xd+i,yd,xd3+i3,yd3,xd3,yd3,200);
      vertexciz(xd2+i2,yd2,xd2+i2,yd2+i2,xd+i,yd+i,xd+i,yd,200);
      vertexciz(xd+i,yd,xd+i,yd+i,xd3+i3,yd3+i3,xd3+i3,yd3,200);
      vertexciz(xd2+i2,yd2+i2,xd2,yd2+i2,xd,yd+i,xd+i,yd+i,200);
      vertexciz(xd+i,yd+i,xd,yd+i,xd3,yd3+i3,xd3+i3,yd3+i3,200);
      vertexciz(xd2,yd2+i2,xd2,yd2,xd,yd,xd,yd+i,200);
      vertexciz(xd,yd+i,xd,yd,xd3,yd3,xd3,yd3+i3,200);

      line (xd,yd,xd3,yd3);
      line (xd+i,yd,xd3+i3,yd3);
      line (xd,yd+i,xd3,yd3+i3);
      line (xd+i,yd+i,xd3+i3,yd3+i3);
    }
    else if (maxi == i3) {
      line (xd3,yd3,xd2,yd2);
      line (xd3,yd3+i3,xd2,yd2+i2);
      line (xd3+i3,yd3,xd2+i2,yd2);
      line (xd3+i3,yd3+i3,xd2+i2,yd2+i2);

      vertexciz(xd3,yd3,xd3+i3,yd3,xd2+i2,yd2,xd2,yd2,200);
      vertexciz(xd2,yd2,xd2+i2,yd2,xd+i,yd,xd,yd,200);
      vertexciz(xd3+i3,yd3,xd3+i3,yd3+i3,xd2+i2,yd2+i2,xd2+i2,yd2,200);
      vertexciz(xd2+i2,yd2,xd2+i2,yd2+i2,xd+i,yd+i,xd+i,yd,200);
      vertexciz(xd3+i3,yd3+i3,xd3,yd3+i3,xd2,yd2+i2,xd2+i2,yd2+i2,200);
      vertexciz(xd2+i2,yd2+i2,xd2,yd2+i2,xd,yd+i,xd+i,yd+i,200);
      vertexciz(xd3,yd3+i3,xd3,yd3,xd2,yd2,xd2,yd2+i2,200);
      vertexciz(xd2,yd2+i2,xd2,yd2,xd,yd,xd,yd+i,200);

      line (xd2,yd2,xd,yd);
      line (xd2+i2,yd2,xd+i,yd);
      line (xd2,yd2+i2,xd,yd+i);
      line (xd2+i2,yd2+i2,xd+i,yd+i);
    }
  }

  noFill();


  float minyakinlik = min(yakinlik,yakinlik2,yakinlik3);
  int minyakinlikr = round(minyakinlik);

  fill(0);
  textSize(17);
  text(minyakinlikr,470,minyakinlik+20); // yak\u0131nl\u0131k yaz\u0131

  fill(255,0,0);
  noStroke();
  rect(470,0,30,minyakinlik); // yak\u0131nl\u0131k yaz\u0131 bar
  noFill();

  int imagex = 45;

  fill(0);
  textSize(20);
  text (can,7,25);
  for (int img=0; img<can; img=img+1) { // kalpler olu\u015fuyor
    image(b,imagex,20);
    imagex = imagex + 35;
  }

  int puanyazi;
  puansalise = puansalise + 70;
  if (puanpause == true) {
    puansalise = puansalise - 70;
  }
  if (puanbonus == true) {
    puansalise = puansalise + 100;
  }
  if (can > 0) {

    puan = (((4*puansalise)/3) / 38);

    puanyazi = round(puan);
  }
  else {
    puan = puan;
    puanyazi = round(puan);
  }
  textSize(25);
  text("Puan :" + puanyazi,10,490); // puan
  //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  //bonuslar


  ik = ik + 1;
  float wrk = 100;
  int ikr = round(ik);
  int kutumillis = millis();
  int kutusn = kutumillis / 1000;

  float minik = min(i,i2,i3);
  float maxik = max(i,i2,i3);
  float ortik = (minik + maxik) / 2;

  float ortxd[] = {
    xd,xd2,xd3
  };
  ortxd = sort(ortxd);
  //print(ortxr[2]);
  float ortyd[] = {
    yd,yd2,yd3
  };
  ortyd = sort(ortyd);

  //println(ortxd[2]+"..."+ortyd[2]);


  float minxr = min(xr,xr2,xr3);
  float maxxr = max(xr,xr2,xr3);


  if (ik > 150) {
    kutux = random(ortxd[2],ortxd[2]+minik);
    kutuy = random(ortyd[2],ortyd[2]+minik);
    ik = 0;
  }

  int timera = millis();

  boolean qbgec;
  //println (buyuktur);
  if (timera > buyuktur) {

    qbgec = true;
    if (qbgec == true) {
      imageMode(CENTER);
      image(qb,kutux,kutuy,ikr,ikr);
    }
    else if (qbgec == false) {
      imageMode(CENTER);
      image(qb2,kutux,kutuy,ikr,ikr);
    }

    ikr = 0;
    if ((wrk - ik) < 0) {
      if (dist(kutux,kutuy,ucakx,ucaky) < 165) {
        blip.trigger();
        if (qbgec != false) {
          float bonusrand = random(1,10);
          if (bonus == 0) {
            bonus = round(bonusrand); // random bonus ata
          }
          else {
            bonus = 0;
          }
        }
        println (bonus);
      }
      qbgec = false;
      buyuktur = timera + 10000;
    }
  }

  int bonuscount;
  if (bonus == 1) {
    //can +
    can = can + 1;
    bonus = 0;
  }
  else if (bonus == 2) {
    //can -
    if (can > 1) {
      can = can - 1;
    }
    else {
      a = 3;
      minim.stop();
      bg.close();
      death.trigger();
    }
    bonus = 0;
  }
  else if (bonus == 3) {
    //ucakboyu +
    image(bonus3,36,430,50,50);

    bonuscountbool = true;
    ucakboyutw = 160;
    ucakboyuth = 60;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      ucakboyutw = 120;
      ucakboyuth = 40;
      bonuscount = 0;
    }
  }
  else if (bonus == 4) {
    //ucakboyu -
    image(bonus4,36,430,50,50);

    bonusresim = bonus4;
    ucakboyutw = 90;
    ucakboyuth = 30;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      ucakboyutw = 120;
      ucakboyuth = 40;
    }
  }
  else if (bonus == 5) {
    //hiz +
    image(bonus5,36,430,50,50);

    bonusresim = bonus5;
    oyunhiziartis = 3;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      oyunhiziartis = 0;
    }
  }
  else if (bonus == 6) {
    //hiz -
    image(bonus6,36,430,50,50);

    bonusresim = bonus6;
    oyunhiziartis = -2;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      oyunhiziartis = 0;
    }
  }
  else if (bonus == 7) {
    //ucak hareket +
    image(bonus7,36,430,50,50);

    bonusresim = bonus7;
    harekethizi = 25;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      harekethizi = 15;
    }
  }
  else if (bonus == 8) {
    //ucak hareket -
    image(bonus8,36,430,50,50);

    bonusresim = bonus8;
    harekethizi = 5;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      harekethizi = 15;
    }
  }
  else if (bonus == 9) {
    //puan x2
    image(bonus9,36,430,50,50);

    bonusresim = bonus9;
    puanbonus = true;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      puanbonus = false;
    }
  }
  else if (bonus == 10) {
    //pause
    image(bonus10,36,430,50,50);

    bonusresim = bonus10;
    puanpause = true;
    bonuscount = frameCount;
    if (bonuscount%601 == 0) {
      bonus = 0;
      puanpause = false;
    }
  }


  //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}


public void ucak() {
  PImage ucak;
  ucak = loadImage("img/ucak.png");
  ucak.resize(ucakboyutw,ucakboyuth);
  ucaky = ucaky + 3;

  if (keyR == true) {
    ucakx = ucakx + harekethizi;

    ucak = loadImage("img/ucaksag1.png");
    ucak.resize(ucakboyutw,ucakboyuth);
  }

  if (keyL == true) {
    ucakx = ucakx - harekethizi;

    ucak = loadImage("img/ucaksol1.png");
    ucak.resize(ucakboyutw,ucakboyuth);
  }


  if (keySP == true) {
    ucaky = ucaky - harekethizi;
  }


  if (ucakx > width) {
    //can = can - 1;
    a = 2;

    ucakx = width/2;
  }
  if (ucakx < 0) {
    // can = can - 1;
    a = 2;

    ucakx = width/2;
  }
  if (ucaky > height) {
    // can = can - 1;
    a = 2;

    ucaky = height/2;
  }
  if (ucaky < 0) {
    // can = can - 1;
    a = 2;

    ucaky = height/2;
  }

  imageMode(CENTER);
  image(ucak,ucakx,ucaky);
}

public void keyPressed() {
  if (keyCode == RIGHT) {
    keyR = true;
  }
  if (keyCode == LEFT) {
    keyL = true;
  }
  if (key == ' ') {
    keySP = true;
  }
}
public void keyReleased() {
  if (keyCode == RIGHT) {
    keyR = false;
  }
  if (keyCode == LEFT) {
    keyL = false;
  }
  if (key == ' ') {
    keySP = false;
  }
}
public void durdur() {
  background (102);
  textSize(30);
  fill(255);
  text("Kalan Can\u0131n\u0131z :"+can1, width/2,height/2);
  textSize(17);
  text("Devam etmek i\u00e7in Space'e bas\u0131n.",width/2,height/2 + 25);
  if (keyPressed) {
    if (key == ' ') {
      oyunhiziartis = 0;
            ucakboyutw = 120;
      ucakboyuth = 40;
            buyuktur = 5000;
      harekethizi = 15;
      bonus = 0;// lksdnvlksdnlkvsndlkgvsd
      a = 1;
    }
  }
}
public void oldun() {
  background (255,0,0);
  textSize(30);
  fill(255);
  text("Puan\u0131n\u0131z :"+round(puan), width/2,height/2);
  textSize(17);
  text("Yeniden ba\u015flamak i\u00e7in Enter'a bas\u0131n.",width/2,height/2 + 25);
  if (keyPressed) {
    if (key == ENTER) {
      can = 10;
      puan = 0;
      puansalise = 0;
      oyunhizi = 2;
      oyunhiziartis = 0;
      ucakboyutw = 120;
      ucakboyuth = 40;
      buyuktur = 5000;
      harekethizi = 15;
      bonus = 0;
      a = 1;
      setup();
      bg.loop();
    }
  }
}

public void draw() {
  background(200);
  if (a == 0) {
    image(menu,0,0,width,height);
    if (keyPressed) {
      if (key == ' ') {
        a = 1;
      }
    }
  }
  if (a == 1) {
    oyun();
    ucak();
  }
  if (a == 2) {
    can1 = can;
    durdur();
  }
  if (a == 3) {
    oldun();
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "JetRunner_Game" });
  }
}
