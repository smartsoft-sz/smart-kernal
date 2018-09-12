package com.smart.service;
import com.smart.model.Code;
import com.smart.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/21.
 */
public interface CodeService extends Service<Code> {

    List<Code> listCodeByCond(String keyword, String codeGroupCode);

    List<Code> listByType(String type);

    String getCodeDesc(String type, String code);

    void saveCode(Code code);

    void updateCode(Code code);
}
