package campreview.android.mappers;

/*
Generic mapping interface
 */
public interface IMapper<TIn,TOut> {
    TOut Map(TIn toMap);
}
