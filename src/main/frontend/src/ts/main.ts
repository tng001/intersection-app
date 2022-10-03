import { CheckboxComponent } from './components/checkbox-component';
import { SubmitButtonComponent } from './components/submit-button-component';

$(window).on('load', (): void => {
    new CheckboxComponent().initComponent();
    new SubmitButtonComponent().initComponent();
});
