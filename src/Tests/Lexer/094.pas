 program pamagiteeee;

 var
 fib0, fib1, fib, sum: integer;
 i, n: byte;

 begin
 readln(n);
 fib0 := 0;
 fib1 := 1;
 if n = 0 then sum := 0 else sum := 1;
 for i := 2 to n do begin
 fib := fib1 + fib0;
 sum := sum + fib;
 fib0 := fib1;
 fib1 := fib
 end;
 writeln(sum)
 end.