program jkjkjk;
const N = 10;
var
    arr: array[1..N,1..N] of integer;
    max: integer;
    i,j: byte;    
begin
    randomize;
    for i:=1 to N do begin
        for j:=1 to N do begin
            arr[i,j] := random(1000);
            write(' |',arr[i,j],'| ');
        end;
        writeln;
    end;
    for i:=1 to N do 
        write(' ----- ');
    writeln;
    for j:=1 to N do begin
        max := arr[1,j];
        for i:=2 to N do
            if arr[i,j] > max then
                max := arr[i,j];
        write('  ',max,'  ');
    end;
    writeln;
end.