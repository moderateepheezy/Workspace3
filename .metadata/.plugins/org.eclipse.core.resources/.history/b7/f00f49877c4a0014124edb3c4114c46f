package com.cchub.cityguide;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.cchub.cityguide.MainActivity.PlaceholderFragment;

/**
 * Fragment used for managing interactions for and presentation of a navigation
 * drawer. See the <a href=
 * "https://developer.android.com/design/patterns/navigation-drawer.html#Interaction"
 * > design guidelines</a> for a complete explanation of the behaviors
 * implemented here.
 */
public class NavigationDrawerFragment extends Fragment {

	/**
	 * Remember the position of the selected item.
	 */
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	/**
	 * Per the design guidelines, you should show the drawer on launch until the
	 * user manually expands it. This shared preference tracks this.
	 */
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	/**
	 * A pointer to the current callbacks instance (the Activity).
	 */
	private NavigationDrawerCallbacks mCallbacks;

	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */
	private ActionBarDrawerToggle mDrawerToggle;

	private DrawerLayout mDrawerLayout;
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	static ArrayList<Parent> listDataHeader;
	static ArrayList<Child> listDataChild;
	private View mFragmentContainerView;

	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;
	private String category;
	private int catID;
	public String title = "";
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public NavigationDrawerFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Read in the flag indicating whether or not the user has demonstrated
		// awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState
					.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}

		// Select either the default item (0) or the last selected item.
		selectItem(mCurrentSelectedPosition);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		expListView = (ExpandableListView) inflater.inflate(
				R.layout.fragment_navigation_drawer, container, false);
		expListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						selectItem(position);
					}
				});
		listDataHeader = prepareListData();

		listAdapter = new ExpandableAdapter(getActivity(), listDataHeader);
		expListView.setAdapter(listAdapter);
		expListView.setItemChecked(mCurrentSelectedPosition, true);

		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// switch(childPosition){
				// case 0:
				Intent i = new Intent();
				//i.putExtra("tilte", listDataHeader.get(groupPosition));
				if (listDataHeader.get(groupPosition).getChildren()
						.get(childPosition).getContent() != null) {
					final Child c = listDataHeader.get(groupPosition).getChildren().get(childPosition);
					title = c.getChildText();
					AlertDialog.Builder builder = new AlertDialog.Builder(
							getActivity());
					builder.setIcon(R.drawable.ic_launcher);
					builder.setTitle("Select One Name:-");
					final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
							getActivity(),
							android.R.layout.select_dialog_singlechoice,
							listDataHeader.get(groupPosition).getChildren()
									.get(childPosition).getContent());
					builder.setNegativeButton("cancel",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});

					builder.setAdapter(arrayAdapter,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									String strName = arrayAdapter
											.getItem(which);
									setCategory(strName);
									setCatID(c.getContentID()[which]);
									//Toast.makeText(getActivity(), "cat and catID>> "+getCategory()+"||"+getCatID(), Toast.LENGTH_SHORT).show();
									
									PlaceholderFragment.getValues(getCategory(),String.valueOf(getCatID()));
									if (mDrawerLayout != null) {
										mDrawerLayout.closeDrawer(mFragmentContainerView);
									}
//									AlertDialog.Builder builderInner = new AlertDialog.Builder(
//											getActivity());
//									builderInner.setMessage(strName);
//									builderInner
//											.setTitle("Your Selected Item is");
//									builderInner
//											.setPositiveButton(
//													"Ok",
//													new DialogInterface.OnClickListener() {
//
//														@Override
//														public void onClick(
//																DialogInterface dialog,
//																int which) {
//															dialog.dismiss();
//														}
//													});
//									builderInner.show();
								}
							});
					builder.show();
				} 
				else if (listDataHeader.get(groupPosition).getChildren()
						.get(childPosition).getContent() == null) {
					title = listDataHeader.get(groupPosition).getChildren().get(childPosition).getChildText();
					setCategory(listDataHeader.get(groupPosition).getChildren().get(childPosition).getChildText());
					setCatID(listDataHeader.get(groupPosition).getChildren().get(childPosition).getChildID());
					Toast.makeText(getActivity(), "cat and catID>> "+getCategory()+"||"+getCatID(), Toast.LENGTH_SHORT).show();
					PlaceholderFragment.getValues(getCategory(),String.valueOf(getCatID()));
					if (mDrawerLayout != null) {
						mDrawerLayout.closeDrawer(mFragmentContainerView);
					}
//					Toast.makeText(
//	                        getActivity().getApplicationContext(),
//	                        listDataHeader.get(groupPosition).getChildren().get(childPosition).getChildText(), Toast.LENGTH_SHORT)
//	                        .show();
				}

				return false;
			}
		});

		return expListView;
	}

	private ArrayList<Parent> prepareListData() {
		// TODO Auto-generated method stub
		listDataHeader = new ArrayList<Parent>();

		// Creating a Parent class object
		for (int i = 1; i < 7; i++) {
			final Parent parent = new Parent();
			// Set value in parent
			// String[] x = {"a", "b", "c"};
			if (i == 1) {
				parent.setText("Prefrence");
				parent.setIcon(R.drawable.favourite1);
				parent.setChildren(new ArrayList<Child>());

			} else if (i == 2) {
				parent.setText("Business");
				parent.setIcon(R.drawable.bb);
				parent.setChildren(new ArrayList<Child>());

				// Set Child value
				final Child child = new Child();
				child.setChildText("Services");
				child.setChildIcon(R.drawable.ic_launcher);
				String[] f = { "Advertising Agencies", "Business Centers",
						"Bribal", "Cyber Cafe", "Catering", "Event Decoration",
						"Garden and LanScaping", "Website Designing" };
				int[] id2= {431, 463, 123, 465, 265, 623, 326, 134};
				child.setContent(f);
				child.setContentID(id2);
				parent.getChildren().add(child);

				// Set Second Child
				final Child child1 = new Child();
				child1.setChildText("Products");
				child1.setChildIcon(R.drawable.ic_launcher);
				String[] p = { "Auto Spare Parts", "Boutiques",
						"Carpet and Rug Dealer", "Computer Software Dealers",
						"Bakery", "Furniture and Fitting", "Generator Dealers",
						"Gift Shop", "Home Accesories", "Home Furnishing",
						"Inverter Dealers", "Laboratory Equipment Dealers",
						"Livestock", "Mobile Phone Accesories",
						"Office Furniture", "Provision Store",
						"Sports Equipment", "Stationery Stores",
						"Textile Dealers", "Building Material Dealers", "Cement Dealers" };
				int[] id ={
						107, 115, 304, 133, 262, 308, 183, 540, 309, 310, 
						185, 238, 93, 938, 403, 548, 1210, 550, 121, 139, 141
						};
				child1.setContent(p);
				child1.setContentID(id);
				parent.getChildren().add(child1);
			} else if (i == 3) {
				parent.setText("Fun and Relaxation");
				parent.setIcon(R.drawable.funny);
				parent.setChildren(new ArrayList<Child>());

				// Set Child value
				final Child child = new Child();
				child.setChildText("Bar");
				int barID = 263;
				child.setChildID(barID);
				parent.getChildren().add(child);

				// Set Second Child
				final Child child1 = new Child();
				child1.setChildText("Fast Food joint");
				int fastFoodID = 267;
				child1.setChildID(fastFoodID);
				parent.getChildren().add(child1);
			} else if (i == 4) {
				parent.setText("Artisans");
				parent.setIcon(R.drawable.workers);
				parent.setChildren(new ArrayList<Child>());

				// Set Child value
				final Child child = new Child();
				child.setChildText("Aluminum Fabricator");
				int aluminumID = 962;
				child.setChildID(aluminumID);
				parent.getChildren().add(child);

				// Set Second Child
				final Child child1 = new Child();
				child1.setChildText("Capenter");
				int capenterID = 320;
				child1.setChildID(capenterID);
				parent.getChildren().add(child1);

				// Set Second Child
				final Child child2 = new Child();
				child2.setChildText("Electrician");
				int electID = 323;
				child2.setChildID(electID);
				parent.getChildren().add(child2);

				// Set Second Child
				final Child child3 = new Child();
				child3.setChildText("Fashoin Designer");
				int fashionID = 244;
				child3.setChildID(fashionID);
				parent.getChildren().add(child3);

				// Set Second Child
				final Child child4 = new Child();
				child4.setChildText("Graphics Designer");
				int graphicsID = 655;
				child4.setChildID(graphicsID);
				parent.getChildren().add(child4);

				// Set Second Child
				final Child child5 = new Child();
				child5.setChildText("Interior Designer");
				int interiorID = 327;
				child5.setChildID(interiorID);
				parent.getChildren().add(child5);
			} else if (i == 5) {
				parent.setText("School");
				parent.setIcon(R.drawable.dd);
				parent.setChildren(new ArrayList<Child>());

				// Set Child value
				final Child child = new Child();
				child.setChildText("Primary School");
				int primarySchoolID = 166;
				child.setChildID(primarySchoolID);
				parent.getChildren().add(child);

				// Set Second Child
				final Child child1 = new Child();
				child1.setChildText("Secondary School");
				int secondarySchoolID = 168;
				child1.setChildID(secondarySchoolID);
				parent.getChildren().add(child1);
			} else if (i == 6) {
				parent.setText("Others");
				parent.setIcon(R.drawable.others);
				parent.setChildren(new ArrayList<Child>());

				final Child child6 = new Child();
				child6.setChildText("Church");
				int churchID = 515;
				child6.setChildID(churchID);
				parent.getChildren().add(child6);
			}
			listDataHeader.add(parent);
		}
		return listDataHeader;
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	/**
	 * Users of this fragment must call this method to set up the navigation
	 * drawer interactions.
	 * 
	 * @param fragmentId
	 *            The android:id of this fragment in its activity's layout.
	 * @param drawerLayout
	 *            The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// set up the drawer's list view with items and click listener

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.navigation_drawer_open, /*
										 * "open drawer" description for
										 * accessibility
										 */
		R.string.navigation_drawer_close /*
										 * "close drawer" description for
										 * accessibility
										 */
		) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				if (!isAdded()) {
					return;
				}

				getActivity().supportInvalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					return;
				}

				if (!mUserLearnedDrawer) {
					// The user manually opened the drawer; store this flag to
					// prevent auto-showing
					// the navigation drawer automatically in the future.
					mUserLearnedDrawer = true;
					SharedPreferences sp = PreferenceManager
							.getDefaultSharedPreferences(getActivity());
					sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true)
							.commit();
				}

				getActivity().supportInvalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}
		};

		// If the user hasn't 'learned' about the drawer, open it to introduce
		// them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	private void selectItem(int position) {
		mCurrentSelectedPosition = position;
		if (expListView != null) {
			expListView.setItemChecked(position, true);
		}
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// If the drawer is open, show the global app actions in the action bar.
		// See also
		// showGlobalContextActionBar, which controls the top-left area of the
		// action bar.
		if (mDrawerLayout != null && isDrawerOpen()) {
			inflater.inflate(R.menu.global, menu);
			showGlobalContextActionBar();
		}
		super.onCreateOptionsMenu(menu, inflater);
//
//		MenuItem item = menu.findItem(R.id.action_example);
//		item.setTitle(title);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

//		if (item.getItemId() == R.id.action_example) {
//			Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT)
//					.show();
//			return true;
//		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * Per the navigation drawer design guidelines, updates the action bar to
	 * show the global app 'context', rather than just what's in the current
	 * screen.
	 */
	private void showGlobalContextActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setTitle(R.string.app_name);
	}

	private ActionBar getActionBar() {
		return ((ActionBarActivity) getActivity()).getSupportActionBar();
	}

	/**
	 * Callbacks interface that all activities using this fragment must
	 * implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);
	}
}
