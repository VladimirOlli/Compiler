 program Poshalystaaaaa;

 var
 n: integer;

 begin
 readln(n);
 while n > 1 do begin
if n mod 2 = 1 then break;
 n := n div 2
 end;
 writeln(n = 1)
 end.