 program ya_staralsa;

 var
a, i, s, count: word;

begin
 read(a);
count := 0;
 while a <> 0 do begin
 s := 0;
 for i := 1 to a do begin
 if a mod i = 0 then inc(s)
 end;
 if s = 2 then inc(count);
 read(a)
 end;
 writeln(count)
 end.