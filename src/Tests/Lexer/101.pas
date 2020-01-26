program konets;
type date = record
        year:1900..2050;
        month:1..12;
        day:1..31;
     end;
 
var
    d: date;
    s: string;
    i, j: byte;
    a: array [1..8] of byte;
 
begin
    write('enter dd.mm.yyyy: ');
    readln(s);
 
    i := 1;
    for j := 1 to 10 do
        if s[j] <> '.' then begin
            a[i] := ord(s[j]) - ord('0');
            i := i + 1
        end;
 
    d.day := 10 * a[1] + a[2];
    d.month := 10 * a[3] + a[4];
    d.year := 1000 * a[5] + 100 * a[6] + 10 * a[7] + a[8];
 
    writeln(d.day);
    writeln(d.month);
    writeln(d.year);
 
readln
end.