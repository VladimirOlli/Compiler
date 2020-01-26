program ReverseNum;

 var
 n, a, b, c: word;

 begin
 readln(n);
 a := n mod 10;
 n := n div 10;
 b := n mod 10;
 n := n div 10;
 c := n;
 n := 100 * a + 10 * b + c;
 writeln(n)
 end.