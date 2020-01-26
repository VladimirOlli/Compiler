var x1,y1,x2,y2,d1,d2:real;
begin
     writeln('enterA(X1,Y1) and B(X2,Y2)');
     readln( x1,y1,x2,y2 );
     d1:=sqrt(sqr(y1)+sqr(x1));
     d2:=sqrt(sqr(y2)+sqr(x2));
     if d1<d2 then writeln('answer A ')
     else if d1>d2 then writeln('answer B ')
     else writeln('Same');
end.