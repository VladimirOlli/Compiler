var x1,y1,x2,y2,d:real;
begin
     writeln('enter A(X1,Y1) and B(X2,Y2)');
     readln( x1,y1,x2,y2 );
     d:=sqrt(sqr(y2-y1)+sqr(x2-x1));
     writeln('long |AB|=',d);
end.