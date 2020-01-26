 program klenin_ne_dyshi;
 var
 n, a, right: longint;
 digits, i: byte;

begin
 readln(n);
 a := n;
 digits := 0;
 while a <> 0 do begin
 a := a div 10;
 inc(digits)
 end;
 right := 0;
 for i := 1 to digits div 2 do begin
 right := right * 10;
 right := right + n mod 10;
 n := n div 10
 end;
 if odd(digits) then n := n div 10;
 writeln(n = right)
 end.