#include<graphics.h>
#include<conio.h>
#include<dos.h>
#include<stdlib.h>
//void light()
int midx,midy;
int main()
{
 int gd = DETECT, gm, mid;
 initgraph(&gd,&gm, "C:\\TC\\BGI");
midx = getmaxx()/2;
 midy = getmaxy()/2; 
//intro setcolor(CYAN); 
settextstyle(TRIPLEX_FONT,HORIZ_DIR, 4);
 settextjustify(CENTER_TEXT, CENTER_TEXT); 
outtextxy(midx, midy+10, "Press any key to start");
 getch();
 cleardevice();
//used for red light
 setcolor(WHITE); 
settextstyle(DEFAULT_FONT, HORIZ_DIR,1); 
rectangle(midx+200,midy-180,midx+260,midy-20); 
circle(midx+230,midy-150,22); 
setfillstyle(SOLID_FILL,RED);
 floodfill(midx+230, midy-150,WHITE);
 outtextxy(midx+230,midy-150,"STOP");
 delay(2000);
 graphdefaults();
 cleardevice();
//used for green light rectangle
(midx+200,midy-180,midx+260,midy-20);
 circle(midx+230,midy-50,22); 
setfillstyle(SOLID_FILL,GREEN);
 floodfill(midx+230, midy-50,WHITE); 
outtextxy(midx+230-7,midy-52,"GO");
 delay(2000); 
cleardevice();
 outtextxy(mid-7,mid+48,"Go"); 
setcolor(WHITE);
for(int i=0; i<600; i++)
 { cleardevice(); 
//green light stay rectangle(midx+200,midy-180,midx+260,midy-20);
 circle(midx+230,midy-50,22);
 setfillstyle(SOLID_FILL,GREEN); 
floodfill(midx+230, midy-50,WHITE);
 outtextxy(midx+230-7,midy-52,"GO"); 
line(0,390,650,390); //ROAD
line(50+i,370,90+i,370); 
arc(110+i,370,0,180,20); 
line(130+i,370,220+i,370);
 arc(240+i,370,0,180,20); 
line(260+i,370,300+i,370); 
line(300+i,370,300+i,350); 
line(300+i,350,240+i,330);
 line(240+i,330,200+i,300); 
line(200+i,300,110+i,300);
 line(110+i,300,80+i,330); 
line(80+i,330,50+i,340); 
line(50+i,340,50+i,370);
line(165+i,305,165+i,330);
 line(165+i,330,230+i,330); 
Line(230+i,330,195+i,305);
 line(195+i,305,165+i,305);

line(160+i,305,160+i,330);
 line(160+i,330,95+i,330); 
line(95+i,330,120+i,305); 
line(120+i,305,160+i,305);
/**wheels**/ 
circle(110+i,370,17); 
circle(240+i,370,17);

delay(20);

}
getch();
}





