// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/samebasename/single_level.proto at 24:1
package com.squareup.wire.protos.single_level;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.TagMap;
import com.squareup.wire.WireField;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

public final class Bars extends Message<Bars> {
  public static final ProtoAdapter<Bars> ADAPTER = ProtoAdapter.newMessageAdapter(Bars.class);

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.protos.single_level.Bar#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Bar> bars;

  public Bars(List<Bar> bars) {
    this(bars, TagMap.EMPTY);
  }

  public Bars(List<Bar> bars, TagMap tagMap) {
    super(tagMap);
    this.bars = immutableCopyOf(bars);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Bars)) return false;
    Bars o = (Bars) other;
    return equals(tagMap(), o.tagMap())
        && equals(bars, o.bars);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = tagMap().hashCode();
      result = result * 37 + (bars != null ? bars.hashCode() : 1);
      super.hashCode = result;
    }
    return result;
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<Bars, Builder> {
    public List<Bar> bars;

    public Builder() {
      bars = newMutableList();
    }

    public Builder(Bars message) {
      super(message);
      if (message == null) return;
      this.bars = copyOf(message.bars);
    }

    public Builder bars(List<Bar> bars) {
      checkElementsNotNull(bars);
      this.bars = bars;
      return this;
    }

    @Override
    public Bars build() {
      return new Bars(bars, buildTagMap());
    }
  }
}