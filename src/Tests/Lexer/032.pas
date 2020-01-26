program ui;
const 
    N = 20;
var 
    a: array[1..N] of integer;
    i: byte;
begin
    randomize;
    for i:=1 to N do begin
        a[i] := random(100);
        write(a[i]);
    end;
    writeln;
    writeln('answer: ');
    for i:=1 to N-1 do
        if a[i] < a[i+1] then 
            write(a[i+1]);
    writeln;
end.