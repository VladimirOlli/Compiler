﻿program  n_4;
  var i, imax: integer; 
      a: array[1..10] of integer;
begin 
  randomize;

  for i:=1 to 10 do a[i]:=random(100);
  for i:=1 to 10 do write(a[i],' ');

  imax:=1;

  for i:=2 to 10 do
    if a[i]>a[imax] then
       imax:=i;

  write('Max   a[', imax, ']=', a[imax])

end.