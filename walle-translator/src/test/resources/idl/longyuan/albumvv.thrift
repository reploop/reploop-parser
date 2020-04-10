namespace java com.qiyi.longyuan.thrift

exception InvalidReadOperation {
   1: optional string message;
}

struct AlbumVVEntity {
   1: optional i64 album_id,
   2: optional i64 vv,
}

struct AlbumPercentVVEntity {
   1: optional i64 album_id,
   2: optional i64 vv,
   3: optional i64 p_percent,
   4: optional i64 m_percent,
}

service AlbumVVRpcService {
   binary getVV(1:binary album_id) throws (1:InvalidReadOperation e);
   binary getZyVV(1:binary album_id) throws (1:InvalidReadOperation e);
   i64 getLongVV(1:i64 album_id) throws (1:InvalidReadOperation e);
   i64 getZyLongVV(1:i64 album_id) throws (1:InvalidReadOperation e);
   map<i64,i64> getMapVV(1:list<i64> album_id) throws (1:InvalidReadOperation e);
   map<i64,i64> getZyMapVV(1:list<i64> album_id) throws (1:InvalidReadOperation e);
   AlbumVVEntity getVVEntity(1:i64 album_id) throws (1:InvalidReadOperation e);
   AlbumVVEntity getZyVVEntity(1:i64 album_id) throws (1:InvalidReadOperation e);

   AlbumPercentVVEntity getVVAndPer(1:binary album_id) throws (1:InvalidReadOperation e);
   AlbumPercentVVEntity getZyVVAndPer(1:binary album_id) throws (1:InvalidReadOperation e);
   AlbumPercentVVEntity getLongVVAndPer(1:i64 album_id) throws (1:InvalidReadOperation e);
   AlbumPercentVVEntity getZyLongVVAndPer(1:i64 album_id) throws (1:InvalidReadOperation e);
   map<i64,AlbumPercentVVEntity> getMapVVAndPer(1:list<i64> album_id) throws (1:InvalidReadOperation e);
   map<i64,AlbumPercentVVEntity> getZyMapVVAndPer(1:list<i64> album_id) throws (1:InvalidReadOperation e);

   i64 getLiveLongVV(1:i64 programIdOrChannelId);
   map<i64,i64> getMapLiveVV(1:list<i64>programIdOrChannelId);
}
