 program vsem_poka;

 var
 count: integer;
i, n: byte;
 c: char;

 begin
readln(n);
 count := 0;
 for i := 1 to n do begin
 read(c);
 if c = '(' then inc(count);
 if c = ')' then dec(count);
 if count = -1 then break
 end;
 writeln(count = 0)
 end.