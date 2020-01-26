program yshe_pochti_konets;
var
        str: string;
        i, count: integer;
begin
        write('Your string: ');
        readln(str);
 
        i := length(str);
        if i > 0 then begin
                count := 1;
                while i > 0 do begin
                        if str[i] = ' ' then
                                count := count + 1;
                        i := i - 1;
                end;
        end
        else
                count := 0;
 
 
        writeln('Number of words: ', count);
readln;
end.