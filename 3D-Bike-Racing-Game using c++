#include<iostream>
#include<fstream>
#include<string.h>
#include<stdio.h>
using namespace std ;
class p{
	public :
	char name[25] ;
	int a ;
	p(char *name, int a){
		this->a = a ;
		strcpy(this->name, name) ;
	}
};
int main(){
	ofstream out ;
	out.open("testfile", ios::app) ;
	char name[25] ;
	p p1("du1", 2) ;
	out.write((char*)&p1, sizeof(p)) ;
	p p2("dur1", 5) ;
	out.write((char *)&p2, sizeof(p));
	out.close() ;
	ifstream in ;
	in.open("testfile", ios::in) ;
	while(!in.eof()){
	in.read((char *)&p1, sizeof(p)) ;
	printf("%s %d\n", p1.name, p1.a) ;
}
	//in.read((char *)&p1, sizeof(p)) ;
	//printf("%s %d\n", p1.name, p1.a) ;
	in.close() ;
	return 0 ;
}
