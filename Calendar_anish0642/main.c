firstday(int y)
{
  int d=0,i;
  for(i=0;i<y;i++)
  {
    d++;
    if(i%4==0)
    {
      if(i%100==0)
      {
      if(i%400==0)
      d++;
      }
      else
      d++;
    }
  }
  d=(d-1)%7;
  return d;
}
noofdays(int m,int y)
{
  int x;
  if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
  x=31;
  else if(m==2&&y%4==0)
  {
    if(y%100==0)
    {
      if(y%400==0)
      x=29;
      else
      x=28;
    }
    else
    x=29;
  }
  else if(m==2)
  x=28;
  else
  x=30;
  return x;
}
main()
{
  int year,i,j,d; char a[12][6]={"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
  printf("Enter the required year:");
  scanf("%d",&year);
  printf("\n\n\n 🗓️WELCOME TO %d\n  ---------------\n\n\n",year);
  d=firstday(year);
  for(i=1;i<=12;i++)
  {
    printf("      %s   %d\n",a[i-1],year);
    printf("  S  M  T  W Th  F  s\n");
    for(j=0;j<d;j++)
    printf("   ");
    for(j=1;j<=noofdays(i,year);j++)
    {
      printf("%3d",j);
      d++;
      d=d%7;
      if(d==0)
      printf("\n");
    }
    printf("\n\n");
  }
}
