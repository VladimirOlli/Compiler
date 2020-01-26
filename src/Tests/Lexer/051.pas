program rgee;
const N = 10;
var arr: array[1..N] of integer;
    i, k: byte;
    sum: integer;
    avr: real;
begin
    writeln('Enter the ten elements of the array:');
    for i:=1 to N do
        read(arr[i]);
    sum := 0;
    i := 1;
    k := 0;
    while i <= N do begin
        if (arr[i] mod 2) = 0 then begin
            sum := sum + arr[i];
            k := k + 1
        end;
        i := i + 2
    end;
    writeln(sum);
    if k <> 0 then begin
        avr := sum / k;
        writeln(avr)
    end
    else
        writeln('No elements');
readln;
end.