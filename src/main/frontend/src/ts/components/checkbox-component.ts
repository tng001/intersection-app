import * as chechbox from 'semantic-ui-checkbox';

export class CheckboxComponent {
    public initComponent = (): void => {
        $('.ui.checkbox').checkbox();
    };
}
