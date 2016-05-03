package com.tianqing.common.util.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 基础数据验证
 * Created by hyb on 2016/4/18.
 */
public class BaseValidator {

    private static javax.validation.Validator validator;
    static{
        validator=Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 返回多个错误
     * @param obj
     * @throws ValidationException
     */
    public void validateMutil(Object obj) throws ValidationException {
        Set<ConstraintViolation<Object>> constraintViolations =
                validator.validate(obj);
        List<String> errList = new ArrayList();

        if (constraintViolations == null || constraintViolations.size() == 0)
            return;

        for (ConstraintViolation<Object> error : constraintViolations) {
            String errorMsg = error.getPropertyPath() + ":" + error.getMessage();
            errList.add(errorMsg);
        }
        throw new ValidationException(errList);
    }

    /**
     * 返回单个错误
     * @param obj
     * @throws ValidationException
     */
    public void validate(Object obj) throws ValidationException {
        Set<ConstraintViolation<Object>> constraintViolations =
                validator.validate(obj);
        String errorMsg = null;
        if (constraintViolations != null && constraintViolations.size() != 0) {
            ConstraintViolation<Object> error = constraintViolations.iterator().next();
            errorMsg = error.getPropertyPath() + ":" + error.getMessage();

            throw new ValidationException(errorMsg);
        }
    }

}
