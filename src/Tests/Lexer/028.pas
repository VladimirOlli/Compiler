﻿program fak;
var a1,a2,b1,b2,c1,c2,x,y,d,dx,dy:real;
begin
   writeln('enter: a1,b1,c1,a2,b2,c2');
   readln(a1,b1,c1,a2,b2,c2);
   d  := (a1*b2-a2*b1);
   dx := (c1*b2-c2*b1);
   dy := (a1*c2-a2*c1);
   if ( d=0 ) and ( (dx=0) or (dy=0) ) then
      writeln('null')
   else if ( d<>0 ) and ( (dx=0) or (dy=0) ) then
      writeln('zero')
   else begin
      x:=dx/d; y:=dy/d;
      writeln('x = ', x);  writeln('y = ', y);
   end;
end.