program postavte_4;
const
    max = 100;
var
    arr: array[1..max] of real;
    n: integer;
    sum, op: real;
    i: integer;
 
begin
    write('elements ');
    readln(n);
 
    write('enter ');
    for i := 1 to n do
        read(arr[i]);
 
    sum := 0;
    for i := 1 to n do
        sum := sum + arr[i];
 
    op := 1;
    for i := 1 to n do
        op := op * arr[i];
 
    writeln('sum ', sum:10:2);
    writeln('ymn', op:20:2);
 
end.