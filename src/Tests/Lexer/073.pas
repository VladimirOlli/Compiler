program dfjgj;
var 
  x: integer;     // 
  c1,c2: integer; // 
begin
  write('enter 2: ');
  readln(x);
  c1 := x div 10;
  c2 := x mod 10;
  writeln('first and second: ',c1,' ',c2);
end.