namespace java com.qiyi.slide.resys

service RecordService {
      string getList(1: string key , 2: string login);
      string getUpdateReminder(1: string uid , 2: string login);
}

