program zdrastvyte_vasha_pizza;
const N = 10;
var
    a: array[1..N] of integer;
    i: byte;
    sum: integer;
begin
    randomize;
    for i:=1 to N do a[i]:=random(10)-5;
    for i:=1 to N do write(a[i]:4);
    writeln;
    sum := 0;
    for i:=1 to N do begin
        if (a[i]<0) and (odd(a[i])=false) then
            sum := sum + a[i];
    end;
    writeln(sum);
end.