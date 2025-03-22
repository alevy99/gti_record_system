package ie.gti.recordsystem.ui;

import ie.gti.recordsystem.service.ServiceManager;
import ie.gti.recordsystem.ui.frame.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FrameManager {

    private final ServiceManager serviceManager;

    public enum FrameType {
        LOGIN(LoginFrame.class), MAIN(MainFrame.class), USER(UserFrame.class), TEACHER(TeacherFrame.class), GROUP(GroupFrame.class);

        private final Class<? extends AbstractFrame> frameClass;

        FrameType(Class<? extends AbstractFrame> frameClass) {
            this.frameClass = frameClass;
        }
    }

    private final Map<FrameType, AbstractFrame> formCache = new HashMap<>();

    @Autowired
    private FrameManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
        // Initialize singleton forms
//        formCache.put(FrameType.LOGIN, new LoginFrame(this, serviceManager));
//        formCache.put(FrameType.MAIN, new MainFrame(this, serviceManager));
    }

    public AbstractFrame getFrame(FrameType frameType) {
        AbstractFrame frame;

        if (formCache.containsKey(frameType)) {
            frame = formCache.get(frameType);
        } else {
            // Create new instance for prototype forms
            try {
                frame = (AbstractFrame) frameType.frameClass.getDeclaredConstructors()[0].newInstance(this, serviceManager);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            formCache.put(frameType, frame);
        }

        return formCache.get(frameType);
    }

    public void showFrame(FrameType formName) {
        getFrame(formName).showForm();
    }
}
