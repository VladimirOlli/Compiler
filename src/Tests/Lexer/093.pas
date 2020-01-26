program Smert;

 var

 L, M, R: integer;

begin
read(L, M, R);
while R <> 0 do begin
 if (L - M) * (R - M) <= 0 then break;
 L := M;
 M := R;
 read(R)
 end;
 if R = 0 then R := L;
 writeln((L - M) * (R - M) > 0)
 end.