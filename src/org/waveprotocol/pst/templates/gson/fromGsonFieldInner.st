$if (f.repeated)$
  JsonArray array = $expr$.getAsJsonArray();
  for (int i = 0; i < array.size(); i++) {
    $if (f.message)$
      $f.javaType$ payload = new $f.javaType$();
      GsonUtil.extractJsonObject(payload, array.get(i), gson, raw);
      add$f.capName$(payload);
    $elseif (f.enum)$
      add$f.capName$(ProtoEnums.valOf(array.get(i).getAsInt(), $f.javaType$.values()));
    $elseif (f.blob)$
      add$f.capName$(new Blob(array.get(i).getAsString()));
    $elseif (f.long)$
      add$f.capName$(GsonUtil.fromJson(array.get(i)));
    $else$
      add$f.capName$(array.get(i).getAs$f.capJavaType$());
    $endif$
  }
$else$
  $if (f.message)$
    $f.javaType$ payload = new $f.javaType$();
    GsonUtil.extractJsonObject(payload, $expr$, gson, raw);
    $f.setter$(payload);
  $elseif (f.enum)$
    $f.setter$(ProtoEnums.valOf($expr$.getAsInt(), $f.javaType$.values()));
  $elseif (f.blob)$
    $f.setter$(new Blob($expr$.getAsString()));
  $elseif (f.long)$
    $f.setter$(GsonUtil.fromJson($expr$));
  $else$
    $f.setter$($expr$.getAs$f.capJavaType$());
  $endif$
$endif$
