program ya_tochno_sdoxny;
var
    str, s: string;
    arr: array[1..255] of string;
    n,i,l: byte;
begin
    readln(str);
    l := length(str);
    n := 0;
    s := '';
    for i:=1 to l do 
        if ((str[i] = ' ') or (i = l)) and (s <> '') then begin
            n := n + 1;
            if (i = l) and (str[i] <> ' ') then s := s + str[i];
            arr[n] := s;
            s := '';
        end
        else
            if str[i] <> ' ' then
                s := s + str[i];
    writeln(n);
    for i:=1 to n do 
        writeln(arr[i],' - ', length(arr[i]));
end.