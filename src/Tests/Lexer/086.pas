program hochy_4;

var
    s1,s2,s3: string;
    i: byte;
begin
    write('String: ');
    readln(s1);
    s2 := '';
    for i:=1 to length(s1) do begin
        s3 := copy(s1,i,1);
        if pos(s3,s2) = 0 then
            s2 := s2 + s3
    end;
    writeln('String: ',s2);
readln;
end.