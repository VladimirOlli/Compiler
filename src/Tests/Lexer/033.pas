program jj;
const N = 20;
var 
    arr: array[1..N] of integer;
    i: byte;
begin
    randomize;
    for i:=1 to N do begin
        arr[i] := random(100) - 75;
        write(arr[i]);
    end;
    writeln;
    for i:=1 to N do
        if arr[i] > 0 then begin
            writeln(i, ' ', arr[i]);
            break;
        end;
end.