program suicide;

var
 a, b, first, last: word;

 begin
 first := 1;
last := 0;
 read(a);
 b := 0;
 if a <> 0 then read(b);
 while b <> 0 do begin
 last := a mod 10;
first := b;
 while first > 9 do begin
 first := first div 10

 end;
if last <> first then break;
 a := b;
 read(b)
 end;
 writeln(last = first)
 end.