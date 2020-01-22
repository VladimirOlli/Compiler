program ferziki;
uses GraphABC;
var
   i,j,k,f,u,h1,y,u1:integer;
   b,b1,s:array [1..8] of byte;
   t:boolean;
procedure kletka(h1,f:integer);
begin
   h1:=0;
   for f:=1 to 4 do
      begin
         setPenColor(clBlack);
         setbrushcolor(clBlack);
         rectangle(0+h1,0,40+h1,40);
         rectangle(0+h1,80,40+h1,120);
         rectangle(0+h1,160,40+h1,200);
         rectangle(0+h1,240,40+h1,280);
         rectangle(40+h1,40,80+h1,80);
         rectangle(40+h1,120,80+h1,160);
         rectangle(40+h1,200,80+h1,240);
         rectangle(40+h1,280,80+h1,320);
         h1:=h1+80;
      end;
end;
procedure sost;
var
   i:integer;
begin
   i:=8;
   while (s[i]=8) and (i>=1) do
      begin
         s[i]:=1;
         i:=i-1;
      end;
   s[i]:=s[i]+1;
end;

begin
   setwindowsize(320,320);
   Window.IsFixedSize:=True;
   for i:=1 to 8 do
      begin
         s[i]:=i;
      end;
   for k:=1 to 16000000 do
      begin
         t:=true;
         for i:=1 to 8 do
            for j:=i+1 to 8 do
               if (abs(s[i]-s[j])=abs(i-j)) or (s[i]=s[j]) then
                  t:=false;
               if t=true then
                  begin
                     kletka(h1,f);
                     setbrushcolor(clPink);
                     setfontsize(10);
                     for i:=1 to 8 do
                        begin
                        circle(i*40-21,s[i]*40-21,15);
                        textout(i*40-24,s[i]*40-28,'F');
                        end;
                     sleep(1000);
                     clearwindow;
                   end;
         sost;
      end;

end.