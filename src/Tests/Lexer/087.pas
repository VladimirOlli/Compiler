 program ya_ymry;

 var
 c, z, r: integer;
 x, n: word;

 begin
 readln(x, n);
 r := 0;
 z := 1;
 while x <> 0 do begin
 r := r + z * (x mod n);
 x := x div n;
 z := z * 10
 end;
 writeln(r)
 end.