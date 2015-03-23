package wien.josh.routinetimer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"Test 1", "Another Test"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.routine_list_item, R.id.routine_list_item_name, items);

        ListView routineList = (ListView) findViewById(R.id.routine_list);
        routineList.setAdapter(adapter);
        routineList.setItemsCanFocus(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        switch (item.getItemId()) {
            case R.id.action_settings:
                // TODO go to settings activity or remove menu item
                return true;
            case R.id.action_new_routine:
                newRoutine();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void newRoutine() {

    }

    public void editRoutine(View view) {
        int position = getPositionForView(view);
    }

    public void startRoutine(View view) {
        int position = getPositionForView(view);
    }

    private int getPositionForView(View view) {
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        return listView.getPositionForView(parentRow);
    }
}
